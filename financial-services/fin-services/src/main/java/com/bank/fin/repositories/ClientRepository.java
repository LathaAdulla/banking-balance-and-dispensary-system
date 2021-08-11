package com.bank.fin.repositories;

import com.bank.fin.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	Client findByClientId(Integer clientId);
	
}
