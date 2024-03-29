package com.tm.transport.response;

import java.math.BigDecimal;
import java.util.Map;

public class DayCollectionResponse {
	
	private Map<String,BigDecimal> vehicleAmountMap;
	private BigDecimal dayCollection;
	/**
	 * @return the vehicleAmountMap
	 */
	public Map<String, BigDecimal> getVehicleAmountMap() {
		return vehicleAmountMap;
	}
	/**
	 * @param vehicleAmountMap the vehicleAmountMap to set
	 */
	public void setVehicleAmountMap(Map<String, BigDecimal> vehicleAmountMap) {
		this.vehicleAmountMap = vehicleAmountMap;
	}
	/**
	 * @return the dayCollection
	 */
	public BigDecimal getDayCollection() {
		return dayCollection;
	}
	/**
	 * @param dayCollection the dayCollection to set
	 */
	public void setDayCollection(BigDecimal dayCollection) {
		this.dayCollection = dayCollection;
	}
	
	
	
}
