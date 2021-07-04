package com.tm.transport.response;

import java.util.Date;

public class VehicleResponse {
	
	private int vehicleId;
	private int totalCapacity;
	private String registrationNo;
	private Date registrationDate;
	private Date lastServiceDate;
	private Date nextServiceDate;
	private Long totalKmRun;
	private int seatsFilled;
	private Long routeId;
	private int seatsAvailable;
	private String currentLocation;
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
	/**
	 * @return the seatsFilled
	 */
	public int getSeatsFilled() {
		return seatsFilled;
	}
	/**
	 * @param seatsFilled the seatsFilled to set
	 */
	public void setSeatsFilled(int seatsFilled) {
		this.seatsFilled = seatsFilled;
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
	/**
	 * @return the currentLocation
	 */
	public String getCurrentLocation() {
		return currentLocation;
	}
	/**
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	
	
}
