package com.bank.fin.services;

import com.bank.fin.model.Currency;
import com.bank.fin.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Integer getDecimalPlaces(String currencyCode) {
        Currency currency = currencyRepository.findByCurrencyCode(currencyCode);
        return  currency == null ? 2 : currency.getDecimalplaces();
    }
}
