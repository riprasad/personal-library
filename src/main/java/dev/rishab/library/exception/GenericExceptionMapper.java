package dev.rishab.library.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import dev.rishab.library.beans.Error;

//This class intentionally doesn't have the @Provider annotation.
//It has been disabled in order to try out other ways of throwing exceptions in JAX-RS

//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		var error = new Error(500, ex.getMessage());
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(error)
				.build();
	}

}
