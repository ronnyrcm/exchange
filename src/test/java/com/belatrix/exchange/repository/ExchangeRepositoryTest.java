package com.belatrix.exchange.repository;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.belatrix.exchange.model.Exchange;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ExchangeRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	@Autowired
	private ExchangeRepository exchangeRepository;


	@Test
	public void testFindByCurrencyFromAndCurrencyTo () {
		//populate
		Exchange exchange = new Exchange();
		exchange.setCurrencyFrom("XXX");
		exchange.setCurrencyTo("YYY");
		exchange.setValue(BigDecimal.ONE);
		entityManager.persist(exchange);
	    entityManager.flush();
	    
	    Exchange found = exchangeRepository.findByCurrencyFromAndCurrencyTo("XXX", "YYY");
	    assertNotNull("Exchange not found", found);
	    System.out.println("found:"+found);
	}
	

}
