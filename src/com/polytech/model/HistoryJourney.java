package com.polytech.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.polytech.model.HistoryJourney.HistoryJourneyId;

@Entity
@IdClass(HistoryJourneyId.class)
public class HistoryJourney implements Serializable {

	private static final long serialVersionUID = 252922554121662955L;

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
	private Calendar date;

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

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public class HistoryJourneyId implements Serializable {

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
