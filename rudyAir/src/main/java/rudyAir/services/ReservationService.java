package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.ReservationException;
import rudyAir.model.compte.Reservation;
import rudyAir.repositories.IClientRepository;
import rudyAir.repositories.IPassagerRepository;
import rudyAir.repositories.IReservationRepository;
import rudyAir.repositories.IVolRepository;

@Service
public class ReservationService {

	@Autowired
	private IReservationRepository reservationRepo;

	@Autowired
	private IVolRepository volRepo;

	@Autowired
	private IClientRepository clientRepo;

	@Autowired
	private IPassagerRepository passagerRepo;

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
		Reservation reservationEnBase = new Reservation();

		if (reservation.getId() == null) {
			reservationEnBase = reservation;
			if (reservation.getVol().getId() != null) {
				reservationEnBase.setVol(volRepo.getById(reservation.getVol().getId()));
			} else {
				reservationEnBase.setVol(reservation.getVol());
			}
			reservationEnBase.setVol(reservation.getVol());
			// Si on a un client en base on vient le chercher
			if (reservation.getClient().getId() != null) {
				reservationEnBase.setClient(clientRepo.getById(reservation.getClient().getId()));
			} else {
				reservationEnBase.setClient(reservation.getClient());
			}
			// Si on a un client en base on vient le chercher
			if (reservation.getPassager().getId() != null) {
				reservationEnBase.setPassager(passagerRepo.getById(reservation.getPassager().getId()));
			} else {
				reservationEnBase.setPassager(reservation.getPassager());
			}

			return reservationRepo.save(reservationEnBase);

		} else {
			reservationEnBase = getById(reservation.getId());
			reservationEnBase.setStatut(reservation.isStatut());
			reservationEnBase.setAnimaux(reservation.getAnimaux());
			reservationEnBase.setBagage(reservation.getBagage());
			reservationEnBase.setSiege(reservation.getSiege());
			// Si on a un compte en base on vient le chercher
			if (reservation.getVol().getId() != null) {
				reservationEnBase.setVol(volRepo.getById(reservation.getVol().getId()));
			} else {
				reservationEnBase.setVol(reservation.getVol());
			}
			reservationEnBase.setVol(reservation.getVol());
			// Si on a un client en base on vient le chercher
			if (reservation.getClient().getId() != null) {
				reservationEnBase.setClient(clientRepo.getById(reservation.getClient().getId()));
			} else {
				reservationEnBase.setClient(reservation.getClient());
			}
			// Si on a un client en base on vient le chercher
			if (reservation.getPassager().getId() != null) {
				reservationEnBase.setPassager(passagerRepo.getById(reservation.getPassager().getId()));
			} else {
				reservationEnBase.setPassager(reservation.getPassager());
			}

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
	
	public List<Reservation> getAllSortedByIdDesc() {
		return reservationRepo.findAllByOrderByIdDesc();
	}
}
