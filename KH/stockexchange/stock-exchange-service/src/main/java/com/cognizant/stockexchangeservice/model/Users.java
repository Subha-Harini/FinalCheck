package com.cognizant.stockexchangeservice.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class Users {
	
	@Id
	@NotNull
	@Column(name="us_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="us_user_name")
	@NotNull
	@Size(min = 2,max=10 , message = "User Name should be between 2 and 10 characters")
	private String userName;
	
	@Column(name="us_password")
	@NotNull
	@Size(min = 3, message = "Password should be between 3 and 10 characters")
	private String password;
	
	@Column(name="us_email")
	@NotNull( message = "email Should not be empty")
	private String email;
	@NotNull
	@Column(name = "us_contact_number")
	@Size(min = 10, message = "Contact number should be 10 numbers")
	private String contactNumber;
	
	@NotNull
	@Column(name = "us_confirmed")
	private boolean confirmed;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "ur_us_id"), 
		inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	private Set<Role> roleList;

	public Users() {
		super();
	}

	public Users(@NotNull int id,
			@NotNull @Size(min = 2, max = 10, message = "User Name should be between 2 and 10 characters") String userName,
			@NotNull @Size(min = 3, message = "Password should be between 3 and 10 characters") String password,
			@NotNull(message = "email Should not be empty") String email,
			@NotNull @Size(min = 10, message = "Contact number should be 10 numbers") String contactNumber,
			@NotNull boolean confirmed, Set<Role> roleList) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.contactNumber = contactNumber;
		this.confirmed = confirmed;
		this.roleList = roleList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", confirmed=" + confirmed + ", roleList=" + roleList + "]";
	}


}
