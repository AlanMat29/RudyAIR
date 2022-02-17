package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.VilleException;
import rudyAir.model.vol.Ville;
import rudyAir.repositories.IAeroportRepository;
import rudyAir.repositories.IVilleRepository;

@Service
public class VilleService {
	@Autowired
	private IVilleRepository villeRepo;
	
	@Autowired
	private IAeroportRepository aeroRepo;
	
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
	
	public Ville getByIdWithAeroports(Long id) {
		return villeRepo.findByIdWithAeroports(id).orElseThrow(VilleException::new);
	}
	public Ville save(Ville ville) {
		// Create new
		if (ville.getId() == null) {
			checkData(ville);
			return villeRepo.save(ville);
		}
		// Update existing
		else {
			Ville villeEnBase = getById(ville.getId());
			villeEnBase.setNom(ville.getNom());
			villeEnBase.setCp(ville.getCp());
			villeEnBase.setAeroports(ville.getAeroports());
			villeEnBase.setVersion(ville.getVersion());
			return villeRepo.save(villeEnBase);
		}
	}
	
	public void deleteById(Long id) {
		villeRepo.delete(getById(id));
	}
	
	public void delete(Ville ville) {
		villeRepo.delete(ville);
	}

}
