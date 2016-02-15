package com.polytech.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.polytech.model.UserAddress.UserAddressId;

@Entity
@IdClass(UserAddressId.class)
public class UserAddress implements Serializable {

	private static final long serialVersionUID = 7704327786710474718L;

	@Id
	@ManyToOne
	private User user;
	@Id
	@ManyToOne
	private Address address;
	@Temporal(TemporalType.DATE)
	private Calendar startingDate;
	@Temporal(TemporalType.DATE)
	private Calendar endingDate;

	public UserAddress() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Calendar getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Calendar startingDate) {
		this.startingDate = startingDate;
	}

	public Calendar getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Calendar endingDate) {
		this.endingDate = endingDate;
	}

	public class UserAddressId implements Serializable {

		private static final long serialVersionUID = 1L;

		private User user;
		private Address address;

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

	}
}
