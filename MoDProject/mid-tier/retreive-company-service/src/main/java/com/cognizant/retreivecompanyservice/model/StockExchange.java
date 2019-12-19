package com.cognizant.retreivecompanyservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "stock_exchange")
public class StockExchange {
	
	@Id
	@NotNull
	@Column(name="ex_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ex_stock_exchange")
	@NotNull
	@Size(min = 2,max=10 , message = "Sector name should be between 2 and 10 characters")
	private String stockExchange;
	
	@Column(name="ex_brief")
	@NotNull
	private String brief;
	
	@Column ( name = "ex_address")
	@NotNull
	private String address;
	
	@Column(name = "ex_remarks")
	@NotNull
	private String remarks;
	
	@Column(name = "ex_logo")
	@NotNull
	private String logo;

	public StockExchange() {
		super();
	}

	
	public StockExchange(@NotNull int id,
			@NotNull @Size(min = 2, max = 10, message = "Sector name should be between 2 and 10 characters") String stockExchange,
			@NotNull String brief, @NotNull String address, @NotNull String remarks, @NotNull String logo) {
		super();
		this.id = id;
		this.stockExchange = stockExchange;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
		this.logo = logo;
	}


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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	@Override
	public String toString() {
		return "StockExchange [id=" + id + ", stockExchange=" + stockExchange + ", brief=" + brief + ", address="
				+ address + ", remarks=" + remarks + "]";
	}

}
