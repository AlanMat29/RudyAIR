package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.PassagerException;
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
			throw new PassagerException("Donnees incorrectes");
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
		checkData(passager);
		if (passager.getId() == null) {
			return passagerRepo.save(passager);
		}
		else {
			Passager passagerEnBase = getById(passager.getId());
			passagerEnBase.setNom(passager.getNom());
			passagerEnBase.setPrenom(passager.getPrenom());
			passagerEnBase.setDateDeNaissance(passager.getDateDeNaissance());
			passagerEnBase.setReservation(passager.getReservation());
			return passagerRepo.save(passagerEnBase);
		}
	}
	
	
	public void delete(Passager passager) {
		passagerRepo.delete(passager);
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}
	
	public boolean exist(Long id) {
		return passagerRepo.existsById(id);
	}
}
