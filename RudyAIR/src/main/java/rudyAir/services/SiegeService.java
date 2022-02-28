package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.ReservationException;
import rudyAir.exceptions.SiegeException;
import rudyAir.model.vol.Siege;
import rudyAir.repositories.ISiegeRepository;

@Service
public class SiegeService {

	@Autowired
	private ISiegeRepository siegeRepo;

	private void checkData(Siege s) {
		if (s.getNumero() <= 0 || s.getNumero() > 800) {
			throw new SiegeException("Donnees incorrectes");
		}
	}

	public List<Siege> getAll() {
		return siegeRepo.findAll();
	}

	public Siege getById(Long id) {
		return siegeRepo.findById(id).orElseThrow(SiegeException::new);
	}

	public Siege getSiegeByReservationId(Long id) {
		return siegeRepo.findSiegeByReservationId(id).orElseThrow(SiegeException::new);
	}

	public List<Siege> getSiegeByAvionId(Long id) {
		return siegeRepo.findSiegesByAvionId(id);
	}

	public Siege save(Siege siege) {
		if (siege == null) {
			throw new ReservationException();
		}
		checkData(siege);
		if (siege.getId() == null) {
			return siegeRepo.save(siege);
		} else {
			Siege siegeEnBase = getById(siege.getId());
			siegeEnBase = getById(siege.getId());
			siegeEnBase.setNumero(siege.getNumero());
			siegeEnBase.setAvion(siege.getAvion());
			return siegeRepo.save(siegeEnBase);
		}
	}

	public void deleteById(Long id) {
		siegeRepo.delete(getById(id));
	}

	public void deleteByReservationId(Long id) {
		siegeRepo.delete(getSiegeByReservationId(id));
	}

	public boolean exist(Long id) {
		return siegeRepo.existsById(id);
	}

}
