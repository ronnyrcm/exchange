package com.belatrix.exchange.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belatrix.exchange.model.Currency;
import com.belatrix.exchange.repository.CurrencyRepository;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	private static final Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);

	@Autowired
	protected CurrencyRepository currencyRepository;

	@Override
	public Currency findById(String id) {
		Optional<Currency> currencyOptional = currencyRepository.findById(id);
		Currency currency = null;
		if (currencyOptional.isPresent()) {
			currency = currencyOptional.get();
			logger.info("Currrency id:" + currency.getId() +
					" name:" + currency.getName() +
					" symbol:" + currency.getSymbol());
		} else {
			logger.info("Currency not found");
		}
		return currency;
	}

}
