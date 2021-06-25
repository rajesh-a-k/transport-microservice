package com.tm.transport.response;

import java.math.BigDecimal;

public class PaymentResponse {
	
	private BigDecimal totalCollection;
	private int seatsAvailable;
	/**
	 * @return the totalCollection
	 */
	public BigDecimal getTotalCollection() {
		return totalCollection;
	}
	/**
	 * @param totalCollection the totalCollection to set
	 */
	public void setTotalCollection(BigDecimal totalCollection) {
		this.totalCollection = totalCollection;
	}
	/**
	 * @return the seatsAvailable
	 */
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	/**
	 * @param seatsAvailable the seatsAvailable to set
	 */
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	
	
}
