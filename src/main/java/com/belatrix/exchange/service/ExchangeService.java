package com.belatrix.exchange.service;

import java.math.BigDecimal;

public interface ExchangeService {
	
	BigDecimal getCurrencyExchange(BigDecimal amount, String currencyFrom, String currencyTo);

}
