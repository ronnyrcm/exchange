package com.belatrix.exchange.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belatrix.exchange.model.Currency;
import com.belatrix.exchange.service.CurrencyService;
import com.belatrix.exchange.service.ExchangeService;

@RestController
public class ExchangeController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExchangeController.class);
	
	@Autowired
	protected ExchangeService exchangeService;
	@Autowired
	protected CurrencyService currencyService;
	
	@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/exchange/{amount}/from/{from}/to/{to}")
    public ResponseEntity<Object> exchange(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String currencyFrom, @PathVariable("to") String currencyTo) {
    	logger.info("las variables son:"+amount + ", " + currencyFrom + ", " + currencyTo);
    	BigDecimal result = exchangeService.getCurrencyExchange(amount, currencyFrom, currencyTo);
    	return new ResponseEntity<Object>(result, HttpStatus.OK);//HttpStatus.BAD_REQUEST, HttpStatus.PRECONDITION_FAILED
    }
    
    @RequestMapping("/currency/{id}")
    public ResponseEntity<Object> currency(@PathVariable("id") String id) {
    	logger.info("las variables son:"+id);
    	Currency currency = currencyService.findById(id);
    	return new ResponseEntity<Object>(currency, HttpStatus.OK);//HttpStatus.BAD_REQUEST, HttpStatus.PRECONDITION_FAILED
    }

}
