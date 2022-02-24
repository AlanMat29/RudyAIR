package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.AeroportException;
import rudyAir.exceptions.ReservationException;
import rudyAir.exceptions.VolException;
import rudyAir.exceptions.VolGeneriqueException;
import rudyAir.model.compte.Client;
import rudyAir.model.compte.Reservation;
import rudyAir.model.vol.Aeroport;
import rudyAir.model.vol.Horaire;
import rudyAir.model.vol.Vol;
import rudyAir.model.vol.VolGenerique;
import rudyAir.repositories.IAeroportRepository;
import rudyAir.repositories.IClientRepository;
import rudyAir.repositories.IReservationRepository;
import rudyAir.repositories.IVolGeneriqueRepository;
import rudyAir.repositories.IVolRepository;

@Service
public class ClientService {

	@Autowired
	private IClientRepository clientRepo;

	@Autowired
	private IReservationRepository resaRepo;
	
	@Autowired
	private IVolGeneriqueRepository volGenRepo;
	
	public List<Client> getAllClient(){
		return clientRepo.findAll();
	}
	
	//TODO mettre dans volgen
	public List<VolGenerique> getVolByPrixDecroissant() {
		return volGenRepo.findVolByPrixDecroissant();
	}
	
	public List<VolGenerique> getVolByPrixCroissant() {
		return volGenRepo.findVolByPrixCroissant();
	}


	public List<Reservation> getAllClientReservations(Client client) {
		if (client == null) {
			throw new ReservationException();
		}
		return resaRepo.findAllClientReservations(client);
	}
}
