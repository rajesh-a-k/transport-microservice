package com.tm.transport.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "route")
@Table(name = "route")
public class Route implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7273984726060688602L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ROUTE_ID")
	private int routeId;
	
	@Column(name="START_POINT")
	private String startPoint;
	
	@Column(name="DESTINATION_POINT")
	private String destinationPoint;
	
	@OneToMany(mappedBy = "route",fetch = FetchType.EAGER )
	private List<Vehicle> vehicles;

	/**
	 * @return the routeId
	 */
	public int getRouteId() {
		return routeId;
	}

	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	/**
	 * @return the startPoint
	 */
	public String getStartPoint() {
		return startPoint;
	}

	/**
	 * @param startPoint the startPoint to set
	 */
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	/**
	 * @return the destinationPoint
	 */
	public String getDestinationPoint() {
		return destinationPoint;
	}

	/**
	 * @param destinationPoint the destinationPoint to set
	 */
	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}

	/**
	 * @return the vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
	
}
