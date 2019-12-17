package com.cognizant.stockmarketcharting.authenticationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="stock_exchange")
public class StockExchange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="st_id")
	private int id;
	
	@Column(name="st_stock_exchange")
	@NotNull 
	private String stockExchange;
	
	@Column(name="st_brief")
	@NotNull 
	private String brief;
	
	@Column(name="st_contact_address")
	@NotNull 
	private String contactAddress;
	
	@Column(name="st_remarks")
	@NotNull 
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public StockExchange() {
		super();
	}

	public StockExchange(int id, @NotNull String stockExchange, @NotNull String brief, @NotNull String contactAddress,
			@NotNull String remarks) {
		super();
		this.id = id;
		this.stockExchange = stockExchange;
		this.brief = brief;
		this.contactAddress = contactAddress;
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "StockExchange [id=" + id + ", stockExchange=" + stockExchange + ", brief=" + brief + ", contactAddress="
				+ contactAddress + ", remarks=" + remarks + "]";
	}
	
	
	
}
