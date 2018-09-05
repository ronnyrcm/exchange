package com.belatrix.exchange.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belatrix.exchange.model.Exchange;
import com.belatrix.exchange.repository.ExchangeRepository;

@Service
public class ExchangeServiceImpl implements ExchangeService {

	private static final Logger logger = LoggerFactory.getLogger(ExchangeServiceImpl.class);

	@Autowired
	protected ExchangeRepository exchangeRepository;

	@Override
	public BigDecimal getCurrencyExchange(BigDecimal amount, String currencyFrom, String currencyTo) {
		Exchange exchange = exchangeRepository.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
		logger.info("Exchange id:" + exchange.getId() +
				" currencyFrom:" + exchange.getCurrencyFrom() +
				" currencyTo:" + exchange.getCurrencyTo() +
				" value:" + exchange.getValue());
		return amount.multiply(exchange.getValue());
	}

}
