package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.SiegeException;
import rudyAir.model.vol.Siege;
import rudyAir.model.vol.SiegeKey;
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

	public Siege getBySiegeKey(SiegeKey siegeKey) {
		return siegeRepo.findById(siegeKey).orElseThrow(SiegeException::new);
	}

	public Siege getSiegeByReservationId(Long id) {
		return siegeRepo.findSiegeByReservationId(id).orElseThrow(SiegeException::new);
	}

	public Siege getSiegeByAvionId(Long id) {
		return siegeRepo.findSiegeByAvionId(id).orElseThrow(SiegeException::new);
	}

	public Siege save(Siege siege) {
		Siege siegeEnBase = null;
		checkData(siege);
		try {
			siegeEnBase = getBySiegeKey(siege.getId());
			siegeEnBase.setNumero(siege.getNumero());
		} catch (SiegeException e) {
			siegeEnBase = siegeRepo.save(siege);
		}
		return siegeEnBase;
	}

	public void deleteBySiegeKey(SiegeKey siegeKey) {
		siegeRepo.delete(getBySiegeKey(siegeKey));
	}

	public void deleteByReservationId(Long id) {
		siegeRepo.delete(getSiegeByReservationId(id));
	}

	public void deleteByAvionId(Long id) {
		siegeRepo.delete(getSiegeByAvionId(id));
	}

	
}
