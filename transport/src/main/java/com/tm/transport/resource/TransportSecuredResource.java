package com.tm.transport.resource;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tm.transport.exception.TransportException;
import com.tm.transport.model.Route;
import com.tm.transport.model.Vehicle;
import com.tm.transport.repository.TransportRepository;
import com.tm.transport.repository.impl.TransportRepositoryImpl;
import com.tm.transport.request.PaymentRequest;
import com.tm.transport.request.RouteRequest;
import com.tm.transport.request.VehicleRequest;
import com.tm.transport.response.DayCollectionResponse;
import com.tm.transport.response.PaymentResponse;
import com.tm.transport.response.RouteResponse;
import com.tm.transport.response.SuccessResponse;
import com.tm.transport.response.VehicleResponse;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Root resource (exposed at "securedtransport" path)
 */
@Path("securedtransport")
public class TransportSecuredResource {
	
	private TransportRepository transportRepo = new TransportRepositoryImpl();

  
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return List<VehicleResponse> that will be returned as a JSON response.
     */
	@GET
    @Path("vehicles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<VehicleResponse> getAllVehicles() throws TransportException {
    	List<VehicleResponse> vehicles = new ArrayList<>();
    	vehicles = transportRepo.findAllVehicles();
        return vehicles;
    }
	
	
	
	/**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return Response that will be returned as a JSON response.
	 * @throws TransportException 
	 * @throws ParseException 
     */
	@POST
    @Path("addvehicle")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response addNewVehicle(VehicleRequest vehicleRequest) throws TransportException, ParseException {
		SuccessResponse successResponse = transportRepo.addVehicle(vehicleRequest);
		return Response.status(200).entity(successResponse).build();
	}
	
	/**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return Response that will be returned as a JSON response.
	 * @throws TransportException 
     */
	@POST
    @Path("addroute")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response addNewRoute(RouteRequest routeRequest) throws TransportException {
		SuccessResponse successResponse = transportRepo.addRoute(routeRequest);
		return Response.status(200).entity(successResponse).build();
	}
	
	 /**
     * Method handling HTTP PUT requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return PaymentResponse that will be returned as a JSON response.
     */
	@PUT
    @Path("payment")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public PaymentResponse makeTicketPayment(PaymentRequest paymentRequest) throws ParseException{
		PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse = transportRepo.doTicketPayment(paymentRequest);
		return paymentResponse;
	}
	
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return DayCollectionResponse that will be returned as a JSON response.
     */
	@GET
    @Path("totalcollection")
    @Produces(MediaType.APPLICATION_JSON)
	public DayCollectionResponse getTotalDayCollection() throws ParseException{
		DayCollectionResponse dayCollectionResponse = new DayCollectionResponse();
		dayCollectionResponse = transportRepo.findTotalDayCollection();
		return dayCollectionResponse;
	}
	
	 /**
     * Method handling HTTP PUT requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return Response that will be returned as a JSON response.
     */
	@PUT
    @Path("updatevehicle")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateVehicle(VehicleRequest vehicleRequest) throws ParseException, TransportException{
		SuccessResponse successResponse = transportRepo.editVehicleDtails(vehicleRequest);
		return Response.status(200).entity(successResponse).build();
	}
	
	/**
     * Method handling HTTP PUT requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return VehicleResponse that will be returned as a JSON response.
     */
	@PUT
    @Path("updatelocation")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public VehicleResponse updateCurrentLocation(VehicleRequest vehicleRequest) {
		VehicleResponse vehicleResponse = transportRepo.editCurrentLocation(vehicleRequest);
		return vehicleResponse;
	}
}
