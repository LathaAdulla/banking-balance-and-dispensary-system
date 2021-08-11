package com.bank.fin.repositories;

import com.bank.fin.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {
    Currency findByCurrencyCode(String currencyCode);
}
