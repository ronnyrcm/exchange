package com.belatrix.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belatrix.exchange.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, String> {

}
