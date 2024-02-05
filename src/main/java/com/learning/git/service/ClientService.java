package com.learning.git.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.learning.git.domain.client.Client;
import com.learning.git.domain.client.ClientDTO;
import com.learning.git.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;
    
    public ClientDTO save(ClientDTO client) {
        Client client2 = new Client(client);
        try {
            
            repository.save(client2);
    
            return client;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<ClientDTO> getAll() {
        List<Client> clients2 = repository.findAll();
        List<ClientDTO> clients = clients2.stream().map(client -> new ClientDTO(client.getName(), client.getAge())).toList();
        return clients;
    } 

    public ClientDTO getOne(Long id) {
        try {
            
            Client client = repository.findById(id).get();
    
            return new ClientDTO(client.getName(), client.getAge());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado o cliente com este Id");
        }
    }

}
