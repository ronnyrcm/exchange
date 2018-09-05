package com.belatrix.exchange.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.belatrix.exchange.model.Exchange;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
	
	@Cacheable("exchange")
	Exchange findByCurrencyFromAndCurrencyTo(@Param("currencyFrom") String currencyFrom, @Param("currencyTo") String currencyTo);

}
