package com.learning.git.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.git.domain.client.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
