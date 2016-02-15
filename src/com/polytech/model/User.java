package com.polytech.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = User.GetByEmailQueryName, query = "SELECT u " + "FROM User u " + "WHERE u.email = :email"),
		@NamedQuery(name = User.GetByFirstAndLastNameQueryName, query = "SELECT u " + "FROM User u " + "WHERE u.firstName = :firstName AND u.lastName= :lastName") })
public class User {
	public static final String EmailParameterName = "email";
	public static final String LastNameParameterName = "lastName";
	public static final String FirstNameParameterName = "firstName";
	public static final String GetByEmailQueryName = "User.GetByEmail";
	public static final String GetByFirstAndLastNameQueryName = "User.GetByFirstAndLastName";

	@Id
	@GeneratedValue
	private long id;
	@Column(length = 64)
	private String firstName;
	@Column(length = 64)
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Calendar birthDate;
	@Column(length = 10)
	private String gender;
	@Column(unique = true, length = 128)
	private String email;
	@Column(length = 64)
	private String password;

	public User() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
