package com.cognizant.stockmarketcharting.authenticationservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ipo_details")
public class IPODetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="ip_id")
	private int id;
	
	@Column(name="ip_company_name")
	@NotNull 
	private int companyName;
	
	@Column(name="ip_stock_exchange")
	@NotNull 
	private String stockExchange;
	
	@Column(name="ip_price_per_share")
	@NotNull 
	private long pricePerShare;
	
	@Column(name="ip_total_shares")
	@NotNull 
	private int totalShares;
	
	@Column(name="ip_open_date_time")
	@NotNull 
	private Date dateTime;
	
	@Column(name="ip_remarks")
	@NotNull 
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyName() {
		return companyName;
	}

	public void setCompanyName(int companyName) {
		this.companyName = companyName;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public long getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(long pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public int getTotalShares() {
		return totalShares;
	}

	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public IPODetails() {
		super();
	}

	public IPODetails(int id, @NotNull int companyName, @NotNull String stockExchange, @NotNull long pricePerShare,
			@NotNull int totalShares, @NotNull Date dateTime, @NotNull String remarks) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.totalShares = totalShares;
		this.dateTime = dateTime;
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "IPODetails [id=" + id + ", companyName=" + companyName + ", stockExchange=" + stockExchange
				+ ", pricePerShare=" + pricePerShare + ", totalShares=" + totalShares + ", dateTime=" + dateTime
				+ ", remarks=" + remarks + "]";
	}
	
	
	
	
	
}