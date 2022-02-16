package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.VolException;
import rudyAir.model.vol.Vol;
import rudyAir.repositories.IVolRepository;

@Service
public class VolService {
	
	
	@Autowired
	private IVolRepository volRepo;
	
	// Un vol doit obligatoirement avoir un numero de vol
	//TODO: Mettre un vérification sur le format du numero de vol: XX0000
	private void checkData(Vol v) {
		if (v.getNumeroVol() == null || v.getNumeroVol().isEmpty()) {
			throw new VolException("Donnees incorrectes");
		}
	}

	
	
	public List<Vol> getAll() {
		return volRepo.findAll();
	}
	
	public Vol getById(Long id) {
		return volRepo.findById(id).orElseThrow(VolException::new);
	}
	
	public Vol save(Vol vol) {
		if(vol==null) {
			throw new VolException();
		}
		if (vol.getId() == null) {
			checkData(vol);
			return volRepo.save(vol);
		}
		else {
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
	
	public void delete(Long id) {
		volRepo.delete(getById(id));
	}

}
