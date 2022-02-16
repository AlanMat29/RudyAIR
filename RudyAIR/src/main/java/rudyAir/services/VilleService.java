package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.VilleException;
import rudyAir.model.vol.Ville;
import rudyAir.repositories.IVilleRepository;

@Service
public class VilleService {
	@Autowired
	private IVilleRepository villeRepo;
	
	private void checkData(Ville ville) {
		if (ville.getNom() == null || ville.getNom().isEmpty()) {
			throw new VilleException("Donnees incorrectes");
		}
	}

	
	public List<Ville> getAll() {
		return villeRepo.findAll();
	}
	
	public Ville getById(Long id) {
		return villeRepo.findById(id).orElseThrow(VilleException::new);
	}
	
	public Ville save(Ville ville) {
		if(ville==null) {
			throw new VilleException();
		}
		if (ville.getId() == null) {
			checkData(ville);
			return villeRepo.save(ville);
		}
		else {
			Ville villeEnBase = getById(ville.getId());
			villeEnBase.setNom(ville.getNom());
			villeEnBase.setCp(ville.getCp());
			villeEnBase.setAeroports(ville.getAeroports());
			return villeRepo.save(villeEnBase);
		}
	}
	
	public void delete(Long id) {
		villeRepo.delete(getById(id));
	}

}
