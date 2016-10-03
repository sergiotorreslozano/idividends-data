package com.idividends.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.idividends.data.domain.Stock;

@Transactional
public interface StockRepository extends JpaRepository<Stock, Long> {

}
