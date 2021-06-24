package com.tm.transport.repository;

import java.util.List;

import com.tm.transport.exception.TransportException;
import com.tm.transport.model.Route;
import com.tm.transport.request.RouteRequest;
import com.tm.transport.request.VehicleRequest;
import com.tm.transport.response.SuccessResponse;
import com.tm.transport.response.VehicleResponse;

public interface TransportRepository {

	List<VehicleResponse> findAllVehicles();

	List<Route> findAllRoutes();

	SuccessResponse addVehicle(VehicleRequest vehicleRequest) throws TransportException;

	SuccessResponse addRoute(RouteRequest routeRequest) throws TransportException;

}
