package com.learning.git.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
