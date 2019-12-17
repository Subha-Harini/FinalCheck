package com.cognizant.stockmarketcharting.authenticationservice.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="stock_price")
public class StockPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="sp_id")
	private int id;
	
	@Column(name="sp_company_code")
	@NotNull 
	private int companyCode;
	
	@Column(name="sp_stock_exchange")
	@NotNull 
	private String stockExchange;
	
	@Column(name="sp_current_price")
	@NotNull 
	private long currentPrice;

	@Column(name="sp_date")
	@NotNull 
	private Date date;
	
	@Column(name="sp_time")
	@NotNull 
	private Time time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public long getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(long currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public StockPrice() {
		super();
	}

	public StockPrice(int id, @NotNull int companyCode, @NotNull String stockExchange, @NotNull long currentPrice,
			@NotNull Date date, @NotNull Time time) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}

	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", companyCode=" + companyCode + ", stockExchange=" + stockExchange
				+ ", currentPrice=" + currentPrice + ", date=" + date + ", time=" + time + "]";
	}
	
	
	
}
