package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.PassagerException;
import rudyAir.exceptions.ReservationException;
import rudyAir.model.compte.Passager;
import rudyAir.model.compte.Reservation;
import rudyAir.repositories.IPassagerRepository;
import rudyAir.repositories.IReservationRepository;


@Service
public class ReservationService {

	@Autowired
	private IReservationRepository resaRepo;
	
	public List<Reservation> getAll(){
		return resaRepo.findAll();
	}
	
	public Reservation getById(Long id) {
		return resaRepo.findById(id).orElseThrow(ReservationException::new);
	}
	
	public void delete(Reservation reservation) {
		resaRepo.delete(reservation);
	}
	
	public void delete(Long id) {
		delete(getById(id));
	}
}
