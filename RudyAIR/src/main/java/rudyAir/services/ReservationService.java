package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.ReservationException;
import rudyAir.exceptions.VilleException;
import rudyAir.model.compte.Reservation;
import rudyAir.repositories.IReservationRepository;


@Service
public class ReservationService {

	@Autowired
	private IReservationRepository reservationRepo;

	private void checkData(Reservation reservation) {
		if (reservation.getVol() == null || reservation.getPassager() == null ||
				reservation.getAnimaux() < 0 || reservation.getAnimaux() == null ||
				reservation.getBagage() < 0) {
			throw new VilleException("Donnees incorrectes");
		}
	}

	public List<Reservation> getAll(){
		return reservationRepo.findAll();
	}

	public Reservation getById(Long id) {
		return reservationRepo.findById(id).orElseThrow(ReservationException::new);
	}

	public Reservation save(Reservation reservation) {
		if(reservation==null) {
			throw new ReservationException();
		}
		// Create new
		if (reservation.getId() == null) {
			checkData(reservation);
			return reservationRepo.save(reservation);
		}
		// Update existing
		else {
			Reservation reservationEnBase = getById(reservation.getId());
			reservationEnBase.setVol(reservation.getVol());
			reservationEnBase.setPassager(reservation.getPassager());
			reservationEnBase.setClient(reservation.getClient());
			reservationEnBase.setStatut(reservation.isStatut());
			reservationEnBase.setAnimaux(reservation.getAnimaux());
			reservationEnBase.setBagage(reservation.getBagage());
			return reservationRepo.save(reservationEnBase);
		}
	}

	public void delete(Reservation reservation) {
		reservationRepo.delete(reservation);
	}

	public void delete(Long id) {
		delete(getById(id));
	}
}
