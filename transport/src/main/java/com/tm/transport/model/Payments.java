package com.tm.transport.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "payments")
@Table(name = "payments")
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAYMENT_ID")
	private int paymentId;
	
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@ManyToOne
	private Vehicle vehicle;

	/**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
