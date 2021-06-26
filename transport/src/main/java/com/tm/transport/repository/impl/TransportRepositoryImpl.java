package com.tm.transport.repository.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;

import com.tm.transport.constants.TransportConstants;
import com.tm.transport.exception.TransportException;
import com.tm.transport.exception.mapper.TransportExceptionMapper;
import com.tm.transport.model.Payments;
import com.tm.transport.model.Route;
import com.tm.transport.model.Vehicle;
import com.tm.transport.repository.TransportRepository;
import com.tm.transport.request.PaymentRequest;
import com.tm.transport.request.RouteRequest;
import com.tm.transport.request.VehicleRequest;
import com.tm.transport.response.DayCollectionResponse;
import com.tm.transport.response.PaymentResponse;
import com.tm.transport.response.RouteResponse;
import com.tm.transport.response.SuccessResponse;
import com.tm.transport.response.VehicleResponse;

public class TransportRepositoryImpl implements TransportRepository{
	
	static EntityManagerFactory factory;
	static EntityManager entityManager;
	
	@Override
	public List<VehicleResponse> findAllVehicles() throws TransportException {
		List<VehicleResponse> vehicleResponses = new ArrayList<>(); 
		beginTransaction();
		String jpql = "select v from vehicle v";
    	Query query = entityManager.createQuery(jpql);
    	List<Vehicle> vehicles = query.getResultList();
    	endTransaction();
    	if(vehicles.isEmpty())
    		throw new TransportException(TransportConstants.VEHICLE_NOT_FOUND);
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
    		vehicleResponse.setSeatsAvailable(vehicle.getTotalCapacity()-vehicle.getSeatsFilled());
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
	public List<RouteResponse> findAllRoutes() throws TransportException {
		List<RouteResponse> routeResponses = new ArrayList<>();
		beginTransaction();
		String jpql = "select r from route r";
    	Query query = entityManager.createQuery(jpql);
    	List<Route> routes = query.getResultList();
    	endTransaction();
    	if(routes.isEmpty())
    		throw new TransportException(TransportConstants.ROUTE_NOT_FOUND);
    	routes.stream().forEach((Route route)->{
    		RouteResponse routeResponse = new RouteResponse();
    		routeResponse.setDestinationPoint(route.getDestinationPoint());
    		routeResponse.setRouteId(route.getRouteId());
    		routeResponse.setStartPoint(route.getStartPoint());
    		routeResponses.add(routeResponse);
    	});
		return routeResponses;
	}

	@Override
	public SuccessResponse addVehicle(VehicleRequest vehicleRequest) throws TransportException, ParseException {
		beginTransaction();
		String jpql = "select v from vehicle v where v.registrationNo =:regNo";
    	Query query = entityManager.createQuery(jpql);
    	query.setParameter("regNo", vehicleRequest.getRegistrationNo());
    	List<Vehicle> vehicles = query.getResultList();
    	endTransaction();
    	if(!vehicles.isEmpty()) {
    		throw new TransportException(TransportConstants.VEHICLE_ALREADY_EXISTS);
    	}
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
		try {
			beginTransaction();
			entityManager.persist(vehicle);
			endTransaction();
		}catch(Exception e) {
			throw new TransportException(TransportConstants.ADD_VEHICLE_ERROR);
		}
		return new SuccessResponse("200","Vehicle addded successfully");
	}

	@Override
	public SuccessResponse addRoute(RouteRequest routeRequest) throws TransportException {
		beginTransaction();
		String jpql = "select r from route r where upper(startPoint)= :startPoint and upper(destinationPoint) =:destinationPoint";
    	Query query = entityManager.createQuery(jpql);
    	query.setParameter("startPoint", routeRequest.getStartPoint().toUpperCase());
    	query.setParameter("destinationPoint", routeRequest.getDestinationPoint().toUpperCase());
    	List<Route> routes = query.getResultList();
    	endTransaction();
    	if(!routes.isEmpty()) {
    		throw new TransportException(TransportConstants.DUPICATE_ROUTE_ERROR);
    	}
		Route route = new Route();
		route.setStartPoint(routeRequest.getStartPoint());
		route.setDestinationPoint(routeRequest.getDestinationPoint());
		try {
			beginTransaction();
			entityManager.persist(route);
			endTransaction();
		}catch(Exception e) {
			throw new TransportException(TransportConstants.ADD_ROUTE_ERROR);
		}
		
		return new SuccessResponse("200","Route addded successfully");
	}

	@Override
	public List<VehicleResponse> findVehiclesByRouteId(Long routeId) throws TransportException {
		List<VehicleResponse> vehicleResponses = new ArrayList<>();
		beginTransaction();
		String jpql = "select v from vehicle v where v.routeId =:routeId";
    	Query query = entityManager.createQuery(jpql);
    	query.setParameter("routeId", routeId);
    	List<Vehicle> vehicles = query.getResultList();
    	endTransaction();
    	if(vehicles.isEmpty()) {
    		throw new TransportException(TransportConstants.VEHICLE_NOT_FOUND);
    	}
    	vehicles.stream().forEach((Vehicle vehicle)->{
    		VehicleResponse vehicleResponse = new VehicleResponse();
    		vehicleResponse.setRegistrationNo(vehicle.getRegistrationNo());
    		vehicleResponse.setRouteId(routeId);
    		vehicleResponse.setSeatsFilled(vehicle.getSeatsFilled());
    		vehicleResponse.setTotalCapacity(vehicle.getTotalCapacity());
    		vehicleResponse.setSeatsAvailable(vehicle.getTotalCapacity()-vehicle.getSeatsFilled());
    		vehicleResponse.setVehicleId(vehicle.getVehicleId());
    		vehicleResponses.add(vehicleResponse);
    	});
		return vehicleResponses;
	}

	@Override
	public PaymentResponse doTicketPayment(PaymentRequest paymentRequest) throws ParseException {
		Payments payments = new Payments();
		payments.setAmount(paymentRequest.getAmount());
		payments.setPaymentDate(Calendar.getInstance().getTime());
		payments.setVehicleId(paymentRequest.getVehicleId());
		beginTransaction();
		entityManager.persist(payments);
		endTransaction();
		beginTransaction();
		Vehicle vehicle = entityManager.find(Vehicle.class, paymentRequest.getVehicleId().intValue());
		vehicle.setSeatsFilled(vehicle.getSeatsFilled()+1);
		entityManager.merge(vehicle);
		endTransaction();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = Calendar.getInstance().getTime();
		String dateString = formatter.format(currentDate);
		currentDate = formatter.parse(dateString);
		beginTransaction();
		String jpql = "select p.amount from payments p where p.vehicleId =:vehicleId and p.paymentDate =:payDate";
    	Query query = entityManager.createQuery(jpql);
    	query.setParameter("vehicleId", paymentRequest.getVehicleId());
    	query.setParameter("payDate", currentDate);
    	List<BigDecimal> amounts = query.getResultList();
    	endTransaction();
		PaymentResponse paymentResponse = new PaymentResponse();
		BigDecimal totalCollection = new BigDecimal(0);
		for(BigDecimal amount:amounts) {
			totalCollection=totalCollection.add(amount);
		}
		paymentResponse.setTotalCollection(totalCollection);
		paymentResponse.setSeatsAvailable(vehicle.getTotalCapacity()-(vehicle.getSeatsFilled()+1));
		return paymentResponse;
	}

	@Override
	public DayCollectionResponse findTotalDayCollection() throws ParseException {
		DayCollectionResponse dayCollectionResponse = new DayCollectionResponse();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = Calendar.getInstance().getTime();
		String dateString = formatter.format(currentDate);
		currentDate = formatter.parse(dateString);
		beginTransaction();
		String jpql = "select p.vehicleId,sum(p.amount) from payments p where p.paymentDate =:payDate group by p.vehicleId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("payDate", currentDate);
		List<Object[]> objectArray = query.getResultList();
		endTransaction();
		Map<Integer,BigDecimal> vehicleAmountMap = new HashMap<>();
		for(Object obj[]:objectArray) {
			vehicleAmountMap.put(new Integer(obj[0].toString()), new BigDecimal(obj[1].toString()));
		}
		BigDecimal totalCollection = new BigDecimal(0);
		for(Map.Entry<Integer, BigDecimal> entry:vehicleAmountMap.entrySet()){
			totalCollection=totalCollection.add(entry.getValue());
		}
		dayCollectionResponse.setVehicleAmountMap(vehicleAmountMap);
		dayCollectionResponse.setDayCollection(totalCollection);
		return dayCollectionResponse;
	}

	@Override
	public SuccessResponse editVehicleDtails(VehicleRequest vehicleRequest) throws ParseException, TransportException {
		if(vehicleRequest.getRegistrationDate()!=null || 
				vehicleRequest.getRegistrationNo()!=null) {
			throw new TransportException(TransportConstants.EDIT_VEHICLE_ERROR);
		}
		beginTransaction();
		Vehicle vehicle = entityManager.find(Vehicle.class, vehicleRequest.getVehicleId());
		endTransaction();
		if(vehicleRequest.getLastServiceDate()!=null) {
			Date lastServiceDate = new SimpleDateFormat("yyyy-MM-dd").parse(vehicleRequest.getLastServiceDate());
			vehicle.setLastServiceDate(lastServiceDate);
		}
		if(vehicleRequest.getNextServiceDate()!=null) {
			Date nextServiceDate = new SimpleDateFormat("yyyy-MM-dd").parse(vehicleRequest.getNextServiceDate());
			vehicle.setNextServiceDate(nextServiceDate);
		}
		if(vehicleRequest.getRouteId()!=null) {
			vehicle.setRouteId(vehicleRequest.getRouteId());
		}
		if(vehicleRequest.getSeatsFilled()!=null) {
			vehicle.setSeatsFilled(vehicleRequest.getSeatsFilled().intValue());
		}
		if(vehicleRequest.getTotalCapacity()!=0) {
			vehicle.setTotalCapacity(vehicleRequest.getTotalCapacity());
		}
		if(vehicleRequest.getTotalKmRun()!=null) {
			vehicle.setTotalKmRun(vehicleRequest.getTotalKmRun());
		}
		beginTransaction();
		entityManager.merge(vehicle);
		endTransaction();
		return new SuccessResponse("200","Vehicle Updated successfully");
	}
	
}
