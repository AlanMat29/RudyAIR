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

	public List<VolGenerique> getAll() {
		return volGeneriqueRepo.findAll();
	}

	public VolGenerique getById(Long id) {
		return volGeneriqueRepo.findById(id).orElseThrow(VolGeneriqueException::new);
	}

	public void delete(VolGenerique volGenerique) {
		volGeneriqueRepo.delete(volGenerique);
	}

	public void delete(Long id) {
		delete(getById(id));
	}

	public VolGenerique save(VolGenerique volGenerique) {
		if(volGenerique==null) {
			throw new VolGeneriqueException();
		}
		if (volGenerique.getId() == null) {
			check(volGenerique);
			return volGeneriqueRepo.save(volGenerique);
		} else {
			VolGenerique volGeneriqueEnBase = getById(volGenerique.getId());
			volGeneriqueEnBase.setPrix(volGenerique.getPrix());
			volGeneriqueEnBase.setNumVolGen(volGenerique.getNumVolGen());
			volGeneriqueEnBase.setHoraire(volGenerique.getHoraire());
			volGeneriqueEnBase.setAeroportDepart(volGenerique.getAeroportDepart());
			volGeneriqueEnBase.setAeroportArrivee(volGenerique.getAeroportArrivee());
			volGeneriqueEnBase.setVol(volGenerique.getVol());
			return volGeneriqueRepo.save(volGeneriqueEnBase);
		}
	}

	private void check(VolGenerique volGenerique) {
		if (volGenerique.getNumVolGen() == null || volGenerique.getNumVolGen().isEmpty()) {
			throw new VolGeneriqueException();
		}
	}

	public boolean exist(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public VolGenerique getByIdWithHoraires(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public VolGenerique getByIdWithVols(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
