package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.AvionException;
import rudyAir.model.vol.Avion;
import rudyAir.repositories.IAvionRepository;

@Service
public class AvionService {

	@Autowired
	private IAvionRepository avionRepo;

	private void checkData(Avion a) {
		if (a.getRef() == null || a.getRef().isEmpty()) {
			throw new AvionException("Donnees incorrectes");
		}
	}

	public List<Avion> getAll() {
		return avionRepo.findAll();
	}

	public Avion getById(Long id) {
		return avionRepo.findById(id).orElseThrow(AvionException::new);
	}

	public Avion save(Avion avion) {
		if (avion == null) {
			throw new AvionException();
		}
		if (avion.getId() == null) {
			checkData(avion);
			return avionRepo.save(avion);
		} else {
			Avion avionEnBase = getById(avion.getId());
			avionEnBase.setRef(avion.getRef());
			avionEnBase.setStatutAvion(avion.getStatutAvion());
			return avionRepo.save(avionEnBase);
		}
	}

	public void deleteById(Long id) {
		avionRepo.delete(getById(id));
	}

	public boolean exist(Long id) {
		return avionRepo.existsById(id);
	}

	public List<Avion> getAllByOrderByRefAsc() {
		return avionRepo.findAllByOrderByRefAsc();
	}
}
