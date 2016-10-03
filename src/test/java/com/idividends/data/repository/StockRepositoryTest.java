package com.idividends.data.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.idividends.data.domain.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(true)
@Transactional
public class StockRepositoryTest {

	@Autowired
	private StockRepository repository;

	@Test
	public void createOne() {
		Stock entity = new Stock("symbol", "market", "name");
		entity = repository.save(entity);
		assertNotNull(entity.getId());
	}

	@Test
	public void updateOne() {
		Stock entity = new Stock("symbol", "market", "name");
		entity = repository.save(entity);
		Stock fromDb = repository.findOne(entity.getId());
		fromDb.setMarket("updated");
		repository.save(fromDb);
		assertEquals(repository.findOne(entity.getId()).getMarket(), "updated");
	}
	
	@Test
	public void findOne() {
		Stock entity = new Stock("symbol", "market", "name");
		entity = repository.save(entity);
		assertEquals(repository.findOne(entity.getId()).getName(), "name");
	}

	@Test
	public void deleteOne() {
		Stock entity = new Stock("symbol", "market", "name");
		entity = repository.save(entity);
		assertNotNull(repository.findOne(entity.getId()));
		repository.delete(entity.getId());
		assertNull(repository.findOne(entity.getId()));
	}
}
