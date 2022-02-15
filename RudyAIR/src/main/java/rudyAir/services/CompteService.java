package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.CompteException;
import rudyAir.model.compte.Compte;
import rudyAir.repositories.IClientRepository;
import rudyAir.repositories.ICompteRepository;

@Service
public class CompteService {

	@Autowired
	private ICompteRepository compteRepo;
	@Autowired
	private IClientRepository clientrepo;
	
	public List<Compte> getAll(){
		return compteRepo.findAll();
	}
	
	public Compte getById(Long id) {
		return compteRepo.findById(id).orElseThrow(CompteException::new);
	}
	
	public Compte createOrUpdate(Compte c) {
		if(c==null) {
			throw new CompteException();
		}
		Compte compteEnBase = null;
		if(c.getId()==null) {
			checkData(c);
			return compteRepo.save(c);
		} else {
			compteEnBase = this.getById(c.getId());
			checkData(c);
			compteEnBase.setNom(c.getNom());
			return compteRepo.save(compteEnBase);
		}
	}
	
	private void checkData(Compte c) {
		if(c==null || c.getId()==null) {
			throw new CompteException("donn�es inconnus");
		}
	}
	
	public void delete(Compte c) {
		if(c==null || c.getId()==null) {
			throw new CompteException();
		}
		Compte compteEnBase = compteRepo.findById(c.getId()).orElseThrow(CompteException::new);
		compteRepo.delete(compteEnBase);
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}
}