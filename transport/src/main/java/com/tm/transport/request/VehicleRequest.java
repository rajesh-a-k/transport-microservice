package com.tm.transport.request;

import java.util.Date;

public class VehicleRequest {
	
	private int vehicleId;
	private int totalCapacity;
	private String registrationNo;
	private String registrationDate;
	private String lastServiceDate;
	private String nextServiceDate;
	private Long totalKmRun;
	private Long seatsFilled;
	private Long routeId;
	private String currentLocation;
	private Long personsExit;
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
	public String getRegistrationDate() {
		return registrationDate;
	}
	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	/**
	 * @return the lastServiceDate
	 */
	public String getLastServiceDate() {
		return lastServiceDate;
	}
	/**
	 * @param lastServiceDate the lastServiceDate to set
	 */
	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	/**
	 * @return the nextServiceDate
	 */
	public String getNextServiceDate() {
		return nextServiceDate;
	}
	/**
	 * @param nextServiceDate the nextServiceDate to set
	 */
	public void setNextServiceDate(String nextServiceDate) {
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
	/**
	 * @return the personsExit
	 */
	public Long getPersonsExit() {
		return personsExit;
	}
	/**
	 * @param personsExit the personsExit to set
	 */
	public void setPersonsExit(Long personsExit) {
		this.personsExit = personsExit;
	}
	
	
}
