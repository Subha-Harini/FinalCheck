package com.cognizant.stockmarketcharting.authenticationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="us_id")
	private int id;
	
	@Column(name="us_name")
	@NotNull 
	private String name;
	
	@Column(name="us_password")
	private String password;
	
	@Column(name="us_user_type")
	@NotNull
	private String userType;
	
	@Column(name="us_email")
	@NotNull
	private String email;
	
	@Column(name="us_mobile_number")
	@NotNull
	private long mobileNumber;
	
	@Column(name="us_status")
	@NotNull
	private String status;

	public User() {
		super();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", userType=" + userType + ", email="
				+ email + ", mobileNumber=" + mobileNumber + ", status=" + status + "]";
	}
	
	
	
}
