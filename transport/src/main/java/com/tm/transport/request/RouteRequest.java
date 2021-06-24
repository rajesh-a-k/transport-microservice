package com.tm.transport.request;

public class RouteRequest {
	
	private int routeId;
	private String startPoint;
	private String destinationPoint;
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
	
	
	
}
