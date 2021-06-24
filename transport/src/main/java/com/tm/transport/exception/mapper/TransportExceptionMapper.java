package com.tm.transport.exception.mapper;



import com.tm.transport.response.ErrorResponse;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class TransportExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		return Response.status(Status.NOT_FOUND).entity(new ErrorResponse("Some error code, 500 or somthing",
				exception.getMessage())).build();
	}

}
