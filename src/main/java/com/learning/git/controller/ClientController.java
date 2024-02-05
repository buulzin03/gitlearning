package com.learning.git.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.git.domain.client.ClientDTO;
import com.learning.git.service.ClientService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @PostMapping
    @Transactional
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO client) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAll() {
        List<ClientDTO> clients = clientService.getAll();
        
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getOne(id));
    }
}
