package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.CompteException;
import rudyAir.model.compte.Compte;
import rudyAir.repositories.ICompteRepository;

@Service
public class CompteService {

	@Autowired
	private ICompteRepository compteRepo;

	private void checkData(Compte c) {
		if (c.getEmail() == null || c.getNom() == null || c.getPrenom() == null) {
			throw new CompteException("donnees inconnus");
		}
	}

	public boolean exist(Long id) {
		return compteRepo.existsById(id);
	}

	public List<Compte> getAll() {
		return compteRepo.findAll();
	}

	public Compte getById(Long id) {
		return compteRepo.findById(id).orElseThrow(CompteException::new);
	}

	public Compte save(Compte c) {
		if (c == null) {
			throw new CompteException();
		}
		checkData(c);
		if (c.getId() == null) {
			return compteRepo.save(c);
		} else {
			Compte compteEnBase = this.getById(c.getId());
			compteEnBase.setNom(c.getNom());
			compteEnBase.setPrenom(c.getPrenom());
			compteEnBase.setDateNaissance(c.getDateNaissance());
			compteEnBase.setEmail(c.getEmail());
			compteEnBase.setPassword(c.getPassword());
			return compteRepo.save(compteEnBase);
		}
	}

	public void delete(Compte c) {
		if (c == null || c.getId() == null) {
			throw new CompteException();
		}
		Compte compteEnBase = compteRepo.findById(c.getId()).orElseThrow(CompteException::new);
		compteRepo.delete(compteEnBase);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

}
