package com.cognizant.stockexchangeservice.dto;

import com.cognizant.stockexchangeservice.model.Sector;

public class CompanyDto {
	
	private int id;
	
	private String name;
	
	private long turnover;
	
	private String ceo;
	
	private boolean listed;
	
	private Sector sector;
	
	private String brief;

	public CompanyDto() {
		super();
	}

	public CompanyDto(int id, String name, long turnover, String ceo, boolean listed, Sector sector, String brief) {
		super();
		this.id = id;
		this.name = name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.listed = listed;
		this.sector = sector;
		this.brief = brief;
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

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", name=" + name + ", turnover=" + turnover + ", ceo=" + ceo + ", listed="
				+ listed + ", sector=" + sector + ", brief=" + brief + "]";
	}

}
