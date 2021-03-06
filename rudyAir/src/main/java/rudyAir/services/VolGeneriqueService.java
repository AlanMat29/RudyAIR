package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.VolGeneriqueException;
import rudyAir.model.vol.VolGenerique;
import rudyAir.repositories.IVolGeneriqueRepository;

@Service
public class VolGeneriqueService {
	@Autowired
	private IVolGeneriqueRepository volGeneriqueRepo;

	private void checkData(VolGenerique volGenerique) {
		if (volGenerique.getNumVolGen() == null || volGenerique.getNumVolGen().isEmpty()) {
			throw new VolGeneriqueException();
		}
	}

	public boolean exist(Long id) {
		return volGeneriqueRepo.existsById(id);
	}

	public List<VolGenerique> getAll() {
		return volGeneriqueRepo.findAll();
	}

	public VolGenerique getById(Long id) {
		return volGeneriqueRepo.findById(id).orElseThrow(VolGeneriqueException::new);
	}

	public VolGenerique save(VolGenerique volGenerique) {
		if (volGenerique == null) {
			throw new VolGeneriqueException();
		}
		if (volGenerique.getId() == null) {
			checkData(volGenerique);
			return volGeneriqueRepo.save(volGenerique);
		} else {
			VolGenerique volGeneriqueEnBase = getById(volGenerique.getId());
			volGeneriqueEnBase.setPrix(volGenerique.getPrix());
			volGeneriqueEnBase.setNumVolGen(volGenerique.getNumVolGen());
			volGeneriqueEnBase.setHoraire(volGenerique.getHoraire());
			volGeneriqueEnBase.setAeroportDepart(volGenerique.getAeroportDepart());
			volGeneriqueEnBase.setAeroportArrivee(volGenerique.getAeroportArrivee());
			return volGeneriqueRepo.save(volGeneriqueEnBase);
		}
	}

	public void delete(VolGenerique VolGenerique) {
		volGeneriqueRepo.delete(VolGenerique);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

	// Additional service
	public List<VolGenerique> getVolGeneriqueByAeroportDepartName(String nom) {
		return volGeneriqueRepo.findVolGeneriqueByAeroportDepartName(nom);
	}

}
