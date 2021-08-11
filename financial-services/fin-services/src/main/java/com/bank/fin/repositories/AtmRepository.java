package com.bank.fin.repositories;

import com.bank.fin.model.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepository extends JpaRepository<Atm, Integer> {
}
