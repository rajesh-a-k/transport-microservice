package com.tm.transport.resource;

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
import com.tm.transport.request.RouteRequest;
import com.tm.transport.request.VehicleRequest;
import com.tm.transport.response.SuccessResponse;
import com.tm.transport.response.VehicleResponse;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("transportresource")
public class TransportResource {
	
	private TransportRepository transportRepo = new TransportRepositoryImpl();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plan response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
  
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return List<VehicleResponse> that will be returned as a JSON response.
     */
	@GET
    @Path("vehicles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<VehicleResponse> getAllVehicles()  {
    	List<VehicleResponse> vehicles = new ArrayList<>();
    	vehicles = transportRepo.findAllVehicles();
        return vehicles;
    }
	
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return List<Route> that will be returned as a JSON response.
     */
	@GET
    @Path("routes")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Route> getAllRoutes() {
		List<Route> routes = new ArrayList<>();
		routes = transportRepo.findAllRoutes();
		return routes;
	}
	
	/**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return Response that will be returned as a JSON response.
	 * @throws TransportException 
     */
	@POST
    @Path("addvehicle")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response addNewVehicle(VehicleRequest vehicleRequest) throws TransportException {
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
}
