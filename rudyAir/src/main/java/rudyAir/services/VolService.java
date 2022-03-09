package rudyAir.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.AeroportException;
import rudyAir.exceptions.VolException;
import rudyAir.model.vol.Vol;
import rudyAir.repositories.IAeroportRepository;
import rudyAir.repositories.IVolRepository;

@Service
public class VolService {

	@Autowired
	private IVolRepository volRepo;

	@Autowired
	private IAeroportRepository aeroportRepo;

	private void checkData(Vol v) {
		if (v.getNumeroVol() == null || v.getNumeroVol().isEmpty()) {
			throw new VolException("Donnees incorrectes");
		}
	}

	public boolean exist(Long id) {
		return volRepo.existsById(id);
	}

	public List<Vol> getAll() {
		return volRepo.findAll();
	}

	public Vol getById(Long id) {
		return volRepo.findById(id).orElseThrow(VolException::new);
	}

	public Vol save(Vol vol) {
		if (vol == null) {
			throw new VolException();
		}
		if (vol.getId() == null) {
			checkData(vol);
			return volRepo.save(vol);
		} else {
			Vol volEnBase = getById(vol.getId());
			volEnBase.setDateArrivee(vol.getDateArrivee());
			volEnBase.setDateDepart(vol.getDateDepart());
			volEnBase.setStatutVol(vol.getStatutVol());
			volEnBase.setNumeroVol(vol.getNumeroVol());
			volEnBase.setVolGenerique(vol.getVolGenerique());
			volEnBase.setAvion(vol.getAvion());
			volEnBase.setReservations(vol.getReservations());
			return volRepo.save(volEnBase);
		}
	}

	public void deleteById(Long id) {
		volRepo.delete(getById(id));
	}

	// Additional service
	public List<Vol> getVolByAeroportDepart(String nomAeroport) {
		if (nomAeroport == null) {
			throw new AeroportException();
		}
		if (!aeroportRepo.findByNom(nomAeroport).isPresent()) {
			throw new AeroportException();
		}
		return volRepo.findVolByNomAeroportDepart(nomAeroport);
	}

	public List<Vol> getVolByAeroportArrivee(String nomAeroport) {
		if (nomAeroport == null) {
			throw new AeroportException();
		}
		if (!aeroportRepo.findByNom(nomAeroport).isPresent()) {
			throw new AeroportException();
		}
		return volRepo.findVolByNomAeroportArrivee(nomAeroport);
	}

	public List<Vol> getVolByDateDepart(LocalDate date) {
		if (date == null) {
			throw new VolException();
		}
		return volRepo.findVolByDateDepart(date);
	}

	public List<Vol> getVolByDateArrivee(LocalDate date) {
		if (date == null) {
			throw new VolException();
		}
		return volRepo.findVolByDateArrivee(date);
	}

	public List<Vol> getVolByPrixDecroissant() {
		return volRepo.findVolByPrixDecroissant();
	}

	public List<Vol> getVolByPrixCroissant() {
		return volRepo.findVolByPrixCroissant();
	}

	public List<Vol> getVolByintervalPrixOrderByPrixDecroissant(double minPrix, double maxPrix) {
		return volRepo.findVolByintervalPrixOrderByPrixDecroissant(minPrix, maxPrix);
	}

	public List<Vol> getVolByintervalPrixOrderByPrixCroissant(double minPrix, double maxPrix) {
		return volRepo.findVolByintervalPrixOrderByPrixCroissant(minPrix, maxPrix);
	}
	
	public List<Vol> getVolByAvionId(Long avionId) {
		return volRepo.findVolByAvionId(avionId);
	}
	
}
