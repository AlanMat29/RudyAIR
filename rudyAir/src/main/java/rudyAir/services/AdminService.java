package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.AdminException;
import rudyAir.model.compte.Admin;
import rudyAir.repositories.IAdminRepository;

@Service
public class AdminService {

	@Autowired
	private IAdminRepository adminRepo;

	private void checkData(Admin c) {
		if (c.getEmail() == null || c.getNom() == null || c.getPrenom() == null) {
			throw new AdminException("donnees inconnus");
		}
	}

	public List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}

	public Admin getById(Long id) {
		return adminRepo.findById(id).orElseThrow(AdminException::new);
	}

	public Admin save(Admin admin) {
		if (admin == null) {
			throw new AdminException();
		}
		if (admin.getId() == null) {
			checkData(admin);
			return adminRepo.save(admin);
		} else {
			Admin adminEnBase = getById(admin.getId());
			adminEnBase.setNom(admin.getNom());
			adminEnBase.setPrenom(admin.getPrenom());
			adminEnBase.setDateNaissance(admin.getDateNaissance());
			adminEnBase.setEmail(admin.getEmail());
			adminEnBase.setPassword(admin.getPassword());
			return adminRepo.save(adminEnBase);
		}
	}

	public void deleteById(Long id) {
		adminRepo.delete(getById(id));
	}

}
