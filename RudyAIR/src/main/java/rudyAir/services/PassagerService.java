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
	
	public List<Passager> getAll(){
		return passagerRepo.findAll();
	}
	
	public Passager getById(Long id) {
		return passagerRepo.findById(id).orElseThrow(PassagerException::new);
	}
	
	public void delete(Passager passager) {
		passagerRepo.delete(passager);
	}
	
	public void delete(Long id) {
		delete(getById(id));
	}
}
