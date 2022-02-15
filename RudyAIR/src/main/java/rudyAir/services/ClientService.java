package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.model.compte.Client;
import rudyAir.repositories.IClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private IClientRepository clientRepo;
	
	public List<Client> getAll(){
		return clientRepo.findAll();
	}
	
	public void delete(Client client) {
		clientRepo.delete(client);
	}

}
