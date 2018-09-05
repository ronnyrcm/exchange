package com.belatrix.exchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.belatrix.exchange.repository.ExchangeRepository;

@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

	private final ExchangeRepository exchangeRepository;

	public AppRunner(ExchangeRepository exchangeRepository) {
		this.exchangeRepository = exchangeRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		logger.info(".... start");
        logger.info("1 -->" + exchangeRepository.findByCurrencyFromAndCurrencyTo("USD", "EUR"));
        logger.info("2 -->" + exchangeRepository.findByCurrencyFromAndCurrencyTo("USD", "EUR"));
        logger.info("3 -->" + exchangeRepository.findByCurrencyFromAndCurrencyTo("USD", "EUR"));
        logger.info("4 -->" + exchangeRepository.findByCurrencyFromAndCurrencyTo("USD", "EUR"));
        logger.info("5 -->" + exchangeRepository.findByCurrencyFromAndCurrencyTo("USD", "EUR"));
	}

}
