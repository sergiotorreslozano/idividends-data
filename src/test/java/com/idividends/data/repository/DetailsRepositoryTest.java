package com.idividends.data.repository;

import static org.junit.Assert.assertEquals;

import java.time.Instant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.idividends.data.domain.Details;
import com.idividends.data.domain.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(true)
@Transactional
public class DetailsRepositoryTest {

	@Autowired
	private DetailsRepository repository;

	@Autowired
	private StockRepository stockRepository;


	@Test
	public void createOne() {
		Stock stock = new Stock("symbol", "market", "name");
		stockRepository.save(stock);
		Details entity = new Details(Instant.now(), stock);
		entity = repository.save(entity);
		assertEquals(repository.findOne(entity.getId()).getStock().getName(), "name");
	}
}
