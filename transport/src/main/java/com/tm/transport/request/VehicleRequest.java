package com.tm.transport.request;

import java.util.Date;

public class VehicleRequest {
	
	private int vehicleId;
	private int totalCapacity;
	private String registrationNo;
	private Date registrationDate;
	private Date lastServiceDate;
	private Date nextServiceDate;
	private Long totalKmRun;
	private Long seatsFilled;
	private Long routeId;
	/**
	 * @return the vehicleId
	 */
	public int getVehicleId() {
		return vehicleId;
	}
	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	/**
	 * @return the totalCapacity
	 */
	public int getTotalCapacity() {
		return totalCapacity;
	}
	/**
	 * @param totalCapacity the totalCapacity to set
	 */
	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	/**
	 * @return the registrationNo
	 */
	public String getRegistrationNo() {
		return registrationNo;
	}
	/**
	 * @param registrationNo the registrationNo to set
	 */
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	/**
	 * @return the registrationDate
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}
	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	/**
	 * @return the lastServiceDate
	 */
	public Date getLastServiceDate() {
		return lastServiceDate;
	}
	/**
	 * @param lastServiceDate the lastServiceDate to set
	 */
	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	/**
	 * @return the nextServiceDate
	 */
	public Date getNextServiceDate() {
		return nextServiceDate;
	}
	/**
	 * @param nextServiceDate the nextServiceDate to set
	 */
	public void setNextServiceDate(Date nextServiceDate) {
		this.nextServiceDate = nextServiceDate;
	}
	/**
	 * @return the totalKmRun
	 */
	public Long getTotalKmRun() {
		return totalKmRun;
	}
	/**
	 * @param totalKmRun the totalKmRun to set
	 */
	public void setTotalKmRun(Long totalKmRun) {
		this.totalKmRun = totalKmRun;
	}
	/**
	 * @return the seatsFilled
	 */
	public Long getSeatsFilled() {
		return seatsFilled;
	}
	/**
	 * @param seatsFilled the seatsFilled to set
	 */
	public void setSeatsFilled(Long seatsFilled) {
		this.seatsFilled = seatsFilled;
	}
	/**
	 * @return the routeId
	 */
	public Long getRouteId() {
		return routeId;
	}
	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	
	
}
