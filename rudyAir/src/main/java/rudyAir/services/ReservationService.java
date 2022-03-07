package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.ReservationException;
import rudyAir.model.compte.Reservation;
import rudyAir.repositories.IReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private IReservationRepository reservationRepo;

	private void checkData(Reservation reservation) {
		if (reservation.getAnimaux() == null || reservation.getBagage() < 0 || reservation.getVol() == null
				|| reservation.getPassager() == null || reservation.getAnimaux() < 0) {
			throw new ReservationException("Donnees incorrectes");
		}
	}

	public List<Reservation> getAll() {
		return reservationRepo.findAll();
	}

	public Reservation getById(Long id) {
		return reservationRepo.findById(id).orElseThrow(ReservationException::new);
	}

	public Reservation save(Reservation reservation) {
		if (reservation == null) {
			throw new ReservationException();
		}
		checkData(reservation);
		if (reservation.getId() == null) {

			return reservationRepo.save(reservation);
		} else {
			Reservation reservationEnBase = getById(reservation.getId());
			reservationEnBase.setStatut(reservation.isStatut());
			reservationEnBase.setAnimaux(reservation.getAnimaux());
			reservationEnBase.setBagage(reservation.getBagage());
			reservationEnBase.setSiege(reservation.getSiege());
			reservationEnBase.setVol(reservation.getVol());
			reservationEnBase.setPassager(reservation.getPassager());
			return reservationRepo.save(reservationEnBase);
		}
	}

	public void delete(Reservation reservation) {
		reservationRepo.delete(reservation);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

	public boolean exist(Long id) {
		return reservationRepo.existsById(id);
	}
}
