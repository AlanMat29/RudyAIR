package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.PassagerException;
import rudyAir.exceptions.VilleException;
import rudyAir.model.compte.Passager;
import rudyAir.repositories.IPassagerRepository;

@Service
public class PassagerService {

	@Autowired
	private IPassagerRepository passagerRepo;
	
	
	private void checkData(Passager passager) {
		if (passager.getNom() == null || passager.getNom().isEmpty() ||
				passager.getPrenom() == null || passager.getPrenom().isEmpty() ||
				passager.getDateDeNaissance() == null) {
			throw new VilleException("Donnees incorrectes");
		}
	}
	
	
	public List<Passager> getAll(){
		return passagerRepo.findAll();
	}
	
	public Passager getById(Long id) {
		return passagerRepo.findById(id).orElseThrow(PassagerException::new);
	}
	
	public Passager save(Passager passager) {
		if(passager==null) {
			throw new PassagerException();
		}
		// Create new
		if (passager.getId() == null) {
			checkData(passager);
			return passagerRepo.save(passager);
		}
		// Update existing
		else {
			Passager passagerEnBase = getById(passager.getId());
			passagerEnBase.setNom(passager.getNom());
			passagerEnBase.setPrenom(passager.getPrenom());
			passagerEnBase.setDateDeNaissance(passager.getDateDeNaissance());
			return passagerRepo.save(passagerEnBase);
		}
	}
	
	
	public void delete(Passager passager) {
		passagerRepo.delete(passager);
	}
	
	public void delete(Long id) {
		delete(getById(id));
	}
}
