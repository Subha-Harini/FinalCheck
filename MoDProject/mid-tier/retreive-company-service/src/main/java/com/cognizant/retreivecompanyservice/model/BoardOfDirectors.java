package com.cognizant.retreivecompanyservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "board_of_directors")
public class BoardOfDirectors {
	

	@Id
	@NotNull
	@Column(name="bd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="bd_name")
	@NotNull
	@Size(min = 2,max=10 , message = "Directors name should be between 2 and 10 characters")
	private String name;
	
	
	public BoardOfDirectors() {
		super();
	}

	public BoardOfDirectors(@NotNull int id,
			@NotNull @Size(min = 2, max = 10, message = "Directors name should be between 2 and 10 characters") String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "BoardOfDirectors [id=" + id + ", name=" + name + "]";
	}
	
	
	


	

}
