package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.VolException;
import rudyAir.model.compte.Abonnement;
import rudyAir.model.compte.Client;
import rudyAir.model.compte.Reservation;
import rudyAir.model.vol.Vol;
import rudyAir.repositories.IClientRepository;
import rudyAir.repositories.IReservationRepository;
import rudyAir.repositories.IVolGeneriqueRepository;
import rudyAir.repositories.IVolRepository;

@Service
public class AdminService {

	@Autowired
	private IClientRepository clientRepo;

	@Autowired
	private IReservationRepository resaRepo;

	@Autowired
	private IVolRepository volRepo;



	public List<Client> getAllClient(){
		return clientRepo.findAll();
	}

	public List<Reservation> getAllReservation(){
		return resaRepo.findAll();
	}

	public List<Vol> getAllVol(){
		return volRepo.findAll();
	}


	
}
