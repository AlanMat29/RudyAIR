package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.model.compte.Admin;
import rudyAir.repositories.IAdminRepository;

@Service
public class AdminService {

	@Autowired
	private IAdminRepository adminRepo;

	public List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}

}
