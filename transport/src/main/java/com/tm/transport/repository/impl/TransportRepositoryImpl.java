package com.tm.transport.repository.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tm.transport.constants.TransportConstants;
import com.tm.transport.exception.TransportException;
import com.tm.transport.model.Route;
import com.tm.transport.model.Vehicle;
import com.tm.transport.repository.TransportRepository;
import com.tm.transport.request.RouteRequest;
import com.tm.transport.request.VehicleRequest;
import com.tm.transport.response.RouteResponse;
import com.tm.transport.response.SuccessResponse;
import com.tm.transport.response.VehicleResponse;

public class TransportRepositoryImpl implements TransportRepository{
	
	static EntityManagerFactory factory;
	static EntityManager entityManager;
	
	@Override
	public List<VehicleResponse> findAllVehicles() {
		List<VehicleResponse> vehicleResponses = new ArrayList<>(); 
		beginTransaction();
		String jpql = "select v from vehicle v";
    	Query query = entityManager.createQuery(jpql);
    	List<Vehicle> vehicles = query.getResultList();
    	endTransaction();
    	vehicles.stream().forEach((Vehicle vehicle)->{
    		VehicleResponse vehicleResponse = new VehicleResponse();
    		vehicleResponse.setLastServiceDate(vehicle.getLastServiceDate());
    		vehicleResponse.setNextServiceDate(vehicle.getNextServiceDate());
    		vehicleResponse.setRegistrationDate(vehicle.getRegistrationDate());
    		vehicleResponse.setRegistrationNo(vehicle.getRegistrationNo());
    		vehicleResponse.setRouteId(vehicle.getRouteId());
    		vehicleResponse.setSeatsFilled(vehicle.getSeatsFilled());
    		vehicleResponse.setTotalCapacity(vehicle.getTotalCapacity());
    		vehicleResponse.setTotalKmRun(vehicle.getTotalKmRun());
    		vehicleResponse.setVehicleId(vehicle.getVehicleId());
    		vehicleResponses.add(vehicleResponse);
    	});
		return vehicleResponses;
	}
	
	private void beginTransaction() {
		factory = Persistence.createEntityManagerFactory("TransportUnit");
    	entityManager = factory.createEntityManager();
    	entityManager.getTransaction().begin();
	}
	
	private void endTransaction() {
		entityManager.getTransaction().commit();
    	entityManager.close();
    	factory.close();
	}

	@Override
	public List<RouteResponse> findAllRoutes() {
		List<RouteResponse> routeResponses = new ArrayList<>();
		beginTransaction();
		String jpql = "select r from route r";
    	Query query = entityManager.createQuery(jpql);
    	List<Route> routes = query.getResultList();
    	endTransaction();
    	routes.stream().forEach((Route route)->{
    		RouteResponse routeResponse = new RouteResponse();
    		routeResponse.setDestinationPoint(route.getDestinationPoint());
    		routeResponse.setNumberOfVehicles(route.getNumberOfVehicles());
    		routeResponse.setRouteId(route.getRouteId());
    		routeResponse.setStartPoint(route.getStartPoint());
    		routeResponses.add(routeResponse);
    	});
		return routeResponses;
	}

	@Override
	public SuccessResponse addVehicle(VehicleRequest vehicleRequest) throws TransportException, ParseException {
			Vehicle vehicle = new Vehicle();
			if(vehicleRequest.getLastServiceDate()!=null) {
				Date lastServiceDate = new SimpleDateFormat("yyyy-MM-dd").parse(vehicleRequest.getLastServiceDate());
				vehicle.setLastServiceDate(lastServiceDate);
			}
			if(vehicleRequest.getNextServiceDate()!=null) {
				Date nextServiceDate = new SimpleDateFormat("yyyy-MM-dd").parse(vehicleRequest.getNextServiceDate());
				vehicle.setNextServiceDate(nextServiceDate);
			}
			if(vehicleRequest.getRegistrationDate()!=null) {
				Date registrationDate = new SimpleDateFormat("yyyy-MM-dd").parse(vehicleRequest.getRegistrationDate());
				vehicle.setRegistrationDate(registrationDate);
			}
			vehicle.setRegistrationNo(vehicleRequest.getRegistrationNo());
			if(vehicleRequest.getRouteId()!=null) {
				vehicle.setRouteId(vehicleRequest.getRouteId());
			}
			vehicle.setTotalCapacity(vehicleRequest.getTotalCapacity());
			vehicle.setTotalKmRun(vehicleRequest.getTotalKmRun());
			beginTransaction();
			entityManager.persist(vehicle);
			endTransaction();
		
		return new SuccessResponse("200","Vehicle addded successfully");
	}

	@Override
	public SuccessResponse addRoute(RouteRequest routeRequest) throws TransportException {
			Route route = new Route();
			route.setStartPoint(routeRequest.getStartPoint());
			route.setDestinationPoint(routeRequest.getDestinationPoint());
			beginTransaction();
			entityManager.persist(route);
			endTransaction();
		
		return new SuccessResponse("200","Route addded successfully");
	}
}
