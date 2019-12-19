package com.cognizant.uploadexcelservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "sector")
public class Sector {
	
	@Id
	@NotNull
	@Column(name="se_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="se_sector_name")
	@NotNull
	@Size(min = 2,max=10 , message = "Sector name should be between 2 and 10 characters")
	private String sectorName;
	
	@Column(name="se_brief")
	@NotNull
	@Size(min = 2,max=400 , message = "Breif should be between 2 to 400 characters")
	private String brief;

	public Sector() {
		super();
	}

	public Sector(@NotNull int id,
			@NotNull @Size(min = 2, max = 10, message = "Sector name should be between 2 and 10 characters") String sectorName,
			@NotNull @Size(min = 2, max = 400, message = "Breif should be between 2 to 400 characters") String brief) {
		super();
		this.id = id;
		this.sectorName = sectorName;
		this.brief = brief;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", sectorName=" + sectorName + ", brief=" + brief + "]";
	}

}
