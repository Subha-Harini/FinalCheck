package com.cognizant.stockexchangeservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "company")
public class Company {
	

	@Id
	@NotNull
	@Column(name="cp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "cp_name")
	private String name;
	
	@NotNull
	@Column(name = "cp_turnover",
			columnDefinition = "BIGINT")
	private long turnover;
	
	@NotNull
	@Column(name = "cp_ceo")
	private String ceo;
	
	@NotNull
	@Column(name = "cp_listed")
	private boolean listed;
	
	@NotNull
	@Column(name = "cp_brief")
	private String brief;
	

	@NotNull
	@Column(name = "cp_logo")
	private String logo;
	
	@NotNull
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "bd_id")
	private Set<BoardOfDirectors> boardOfDirectors;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "cp_se_id")
	private Sector sector;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "company_stock", 
			joinColumns = @JoinColumn(name = "cs_cp_id"), 
		inverseJoinColumns = @JoinColumn(name = "cs_ex_id"))
	private Set<StockExchange> stockExchange;

	public Company() {
		super();
	}

	
	
	public Company(@NotNull int id, @NotNull String name, @NotNull long turnover, @NotNull String ceo,
			@NotNull boolean listed, @NotNull String brief, @NotNull String logo,
			@NotNull Set<BoardOfDirectors> boardOfDirectors, @NotNull Sector sector, Set<StockExchange> stockExchange) {
		super();
		this.id = id;
		this.name = name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.listed = listed;
		this.brief = brief;
		this.logo = logo;
		this.boardOfDirectors = boardOfDirectors;
		this.sector = sector;
		this.stockExchange = stockExchange;
	}



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

	public boolean isListed() {
		return listed;
	}

	public void setListed(boolean listed) {
		this.listed = listed;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Set<BoardOfDirectors> getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(Set<BoardOfDirectors> boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Set<StockExchange> getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(Set<StockExchange> stockExchange) {
		this.stockExchange = stockExchange;
	}

	public String getLogo() {
		return logo;
	}



	public void setLogo(String logo) {
		this.logo = logo;
	}



	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", turnover=" + turnover + ", ceo=" + ceo + ", listed=" + listed
				+ ", brief=" + brief + ", boardOfDirectors=" + boardOfDirectors + ", sector=" + sector + "]";
	}

	
	
}
