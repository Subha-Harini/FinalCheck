package com.cognizant.uploadexcelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.uploadexcelservice.model.StockPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Integer>{

}
