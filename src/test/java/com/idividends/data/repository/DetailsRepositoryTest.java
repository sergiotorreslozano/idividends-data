package com.idividends.data.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.Instant;

import org.junit.Before;
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

	private Stock stock;

	@Before
	public void setUp() {
		stock = new Stock("symbol", "market", "name");
		stockRepository.save(stock);
		stockRepository.findAll();
	}

	@Test
	public void createOne() {
		Details entity = new Details(Instant.now(), stock);
		entity = repository.save(entity);
		assertNotNull(repository.findOne(entity.getId()));
	}

	@Test
	public void updateOne() {
		Details entity = new Details(Instant.now(), stock);
		entity = repository.save(entity);
		Details fromDb = repository.findOne(entity.getId());
		fromDb.setHigh(1);
		repository.save(fromDb);
		assertEquals(repository.findOne(entity.getId()).getHigh(), new Integer(1));
	}

	@Test
	public void findOne() {
		Details entity = new Details(Instant.now(), stock);
		entity = repository.save(entity);
		assertEquals(repository.findOne(entity.getId()).getStock().getName(), "name");
	}

	@Test
	public void deleteOne() {
		Details entity = new Details(Instant.now(), stock);
		entity = repository.save(entity);
		assertNotNull(repository.findOne(entity.getId()));
		repository.delete(entity.getId());
		assertNull(repository.findOne(entity.getId()));
	}
}
