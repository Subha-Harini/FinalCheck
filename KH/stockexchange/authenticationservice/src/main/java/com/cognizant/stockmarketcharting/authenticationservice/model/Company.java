package com.cognizant.stockmarketcharting.authenticationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="co_id")
	private int id;

	@Column(name="co_name")
	@NotNull 
	private String name;
	
	@Column(name="co_turnover")
	@NotNull 
	private long turnover;
	
	@Column(name="co_ceo")
	@NotNull 
	private String ceo;

	@Column(name="co_board_of_directors")
	@NotNull 
	private String boardOfDirectors;
	
	@Column(name="co_stock_exchange")
	@NotNull 
	private boolean stockExchange;
	
	@Column(name="co_sector")
	@NotNull 
	private String sector;
	
	@Column(name="co_breif_writeup")
	@NotNull 
	private String breifWriteup;
	
	@Column(name="co_stock_code")
	@NotNull 
	private int stockCode;
	
	@ManyToOne
	@JoinColumn(name="co_se_id")
	private Sector sectorDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTurnover() {
		return turnover;
	}

	public void setTurnover(long turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public boolean isStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(boolean stockExchange) {
		this.stockExchange = stockExchange;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getBreifWriteup() {
		return breifWriteup;
	}

	public void setBreifWriteup(String breifWriteup) {
		this.breifWriteup = breifWriteup;
	}

	public int getStockCode() {
		return stockCode;
	}

	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}

	public Sector getSectorDetails() {
		return sectorDetails;
	}

	public void setSectorDetails(Sector sectorDetails) {
		this.sectorDetails = sectorDetails;
	}

	public Company() {
		super();
	}

	public Company(int id, @NotNull String name, @NotNull long turnover, @NotNull String ceo,
			@NotNull String boardOfDirectors, @NotNull boolean stockExchange, @NotNull String sector,
			@NotNull String breifWriteup, @NotNull int stockCode, Sector sectorDetails) {
		super();
		this.id = id;
		this.name = name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.stockExchange = stockExchange;
		this.sector = sector;
		this.breifWriteup = breifWriteup;
		this.stockCode = stockCode;
		this.sectorDetails = sectorDetails;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", turnover=" + turnover + ", ceo=" + ceo
				+ ", boardOfDirectors=" + boardOfDirectors + ", stockExchange=" + stockExchange + ", sector=" + sector
				+ ", breifWriteup=" + breifWriteup + ", stockCode=" + stockCode + ", sectorDetails=" + sectorDetails
				+ "]";
	}
	
	
	
	
}
