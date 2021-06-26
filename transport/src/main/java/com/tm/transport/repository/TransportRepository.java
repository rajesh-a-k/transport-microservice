package com.tm.transport.repository;

import java.text.ParseException;
import java.util.List;

import com.tm.transport.exception.TransportException;
import com.tm.transport.model.Route;
import com.tm.transport.request.PaymentRequest;
import com.tm.transport.request.RouteRequest;
import com.tm.transport.request.VehicleRequest;
import com.tm.transport.response.DayCollectionResponse;
import com.tm.transport.response.PaymentResponse;
import com.tm.transport.response.RouteResponse;
import com.tm.transport.response.SuccessResponse;
import com.tm.transport.response.VehicleResponse;

public interface TransportRepository {

	List<VehicleResponse> findAllVehicles() throws TransportException;

	List<RouteResponse> findAllRoutes() throws TransportException;

	SuccessResponse addVehicle(VehicleRequest vehicleRequest) throws TransportException,ParseException;

	SuccessResponse addRoute(RouteRequest routeRequest) throws TransportException;

	List<VehicleResponse> findVehiclesByRouteId(Long routeId) throws TransportException;

	PaymentResponse doTicketPayment(PaymentRequest paymentRequest) throws ParseException;

	DayCollectionResponse findTotalDayCollection() throws ParseException;

	SuccessResponse editVehicleDtails(VehicleRequest vehicleRequest) throws ParseException, TransportException;

}
