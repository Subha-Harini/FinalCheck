package com.cognizant.stockmarketcharting.authenticationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="sector")
public class Sector {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="se_id")
	private int id;

	@Column(name="se_name")
	@NotNull 
	private String name;
	
	@Column(name="se_brief")
	@NotNull 
	private String breif;

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

	public String getBreif() {
		return breif;
	}

	public void setBreif(String breif) {
		this.breif = breif;
	}

	public Sector() {
		super();
	}

	public Sector(int id, @NotNull String name, @NotNull String breif) {
		super();
		this.id = id;
		this.name = name;
		this.breif = breif;
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", name=" + name + ", breif=" + breif + "]";
	}
	
	
	
}
