package com.tm.transport.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "vehicle")
@Table(name = "vehicle", schema = "transport")
public class Vehicle implements Serializable{
	
	
	private static final long serialVersionUID = 7428709483822346973L;

	@Id
	@Column(name = "VEHICLE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vehicleId;
	
	@Column(name = "TOTAL_CAPACITY")
	private int totalCapacity;
	
	@Column(name = "REGISTRATION_NO")
	private String registrationNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE")
	private Date registrationDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_SERVICE_DATE")
	private Date lastServiceDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "NEXT_SERVICE_DATE")
	private Date nextServiceDate;
	
	@Column(name = "TOTAL_KM_RUN")
	private Long totalKmRun;
	
	@Column(name = "SEATS_FILLED")
	private int seatsFilled;
	
	@Column(name = "ROUTE_ID")
	private Long routeId;
	
	@Column(name = "CURRENT_LOCATION")
	private String currentLocation;
	
	@ManyToOne
	@JoinColumn(name = "ROUTE_ID", insertable = false , updatable = false)
	private Route route;
	
	@OneToMany(mappedBy = "vehicle")
	private List<Payments> payments;

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
	 * @return the route
	 */
	public Route getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(Route route) {
		this.route = route;
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
	 * @return the payments
	 */
	public List<Payments> getPayments() {
		return payments;
	}

	/**
	 * @param payments the payments to set
	 */
	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}
	
	
	
}


