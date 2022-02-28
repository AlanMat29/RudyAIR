package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.ClientException;
import rudyAir.model.compte.Client;
import rudyAir.model.compte.Reservation;
import rudyAir.repositories.IClientRepository;

@Service
public class ClientService {

	@Autowired
	private IClientRepository clientRepo;

	private void checkData(Client c) {
		if (c.getEmail() == null || c.getNom() == null || c.getPrenom() == null) {
			throw new ClientException("donnees inconnus");
		}
	}

	public List<Client> getAllClient() {
		return clientRepo.findAll();
	}

	public Client getById(Long id) {
		return clientRepo.findById(id).orElseThrow(ClientException::new);
	}

	public Client save(Client client) {
		if (client == null) {
			throw new ClientException();
		}
		if (client.getId() == null) {
			checkData(client);
			return clientRepo.save(client);
		} else {
			Client clientEnBase = getById(client.getId());
			clientEnBase.setNom(client.getNom());
			clientEnBase.setPrenom(client.getPrenom());
			clientEnBase.setDateNaissance(client.getDateNaissance());
			clientEnBase.setEmail(client.getEmail());
			clientEnBase.setPassword(client.getPassword());
			clientEnBase.setAdresse(client.getAdresse());
			clientEnBase.setAbonnement(client.getAbonnement());
			return clientRepo.save(clientEnBase);
		}
	}

	public void deleteById(Long id) {
		clientRepo.delete(getById(id));
	}

	// Additional service
	public List<Reservation> getAllClientReservationsByClientId(Long id) {
		if (id == null) {
			throw new ClientException();
		}
		return clientRepo.findAllClientReservationsByClientId(id);
	}
}
