package com.bank.fin.repositories;

import com.bank.fin.model.CurrencyConversionRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionRateRepository extends JpaRepository<CurrencyConversionRate, String> {
    CurrencyConversionRate findByCurrencyCode(String currencyCode);
}
