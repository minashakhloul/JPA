package com.polytech.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.polytech.model.BookmarkedJourney.BookmarkedJourneyId;

@Entity
@IdClass(BookmarkedJourneyId.class)
public class BookmarkedJourney implements Serializable {

	private static final long serialVersionUID = 5212519495054390058L;

	@Id
	@ManyToOne
	private User user;
	@Id
	@ManyToOne
	private Address firstAddress;
	@Id
	@ManyToOne
	private Address secondAddress;
	@Temporal(TemporalType.DATE)
	private Calendar startingDate;
	@Temporal(TemporalType.DATE)
	private Calendar endingDate;

	public BookmarkedJourney() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getFirstAddress() {
		return firstAddress;
	}

	public void setFirstAddress(Address firstAddress) {
		this.firstAddress = firstAddress;
	}

	public Address getSecondAddress() {
		return secondAddress;
	}

	public void setSecondAddress(Address secondAddress) {
		this.secondAddress = secondAddress;
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

	public class BookmarkedJourneyId implements Serializable {

		private static final long serialVersionUID = 1L;

		private User user;
		private Address firstAddress;
		private Address secondAddress;

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Address getFirstAddress() {
			return firstAddress;
		}

		public void setFirstAddress(Address firstAddress) {
			this.firstAddress = firstAddress;
		}

		public Address getSecondAddress() {
			return secondAddress;
		}

		public void setSecondAddress(Address secondAddress) {
			this.secondAddress = secondAddress;
		}
	}
}
