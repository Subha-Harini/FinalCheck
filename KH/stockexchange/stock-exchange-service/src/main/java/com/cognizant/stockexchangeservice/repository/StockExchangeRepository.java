
package com.cognizant.stockexchangeservice.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.stockexchangeservice.model.Company;
import com.cognizant.stockexchangeservice.model.StockExchange;


@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchange, Integer>{
	
	@Query(value = "select * from stock_market.stock_exchange",nativeQuery = true)
	public Set<StockExchange> getAllExchange();
	
	
	@Query(value = "select * from company inner join company_stock on company.cp_id = company_stock.cs_cp_id  inner join stock_exchange on company_stock.cs_ex_id = stock_exchange.ex_id where stock_exchange.ex_stock_exchange = :stockExchangeName ",nativeQuery = true)
	public Set<Object> getAllCompany(@Param("stockExchangeName") String StockExchangeName);

}
