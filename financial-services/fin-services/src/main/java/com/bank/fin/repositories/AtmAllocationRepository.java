package com.bank.fin.repositories;

import com.bank.fin.model.AtmAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmAllocationRepository extends JpaRepository<AtmAllocation, Integer> {
}
