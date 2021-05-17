package dev.rishab.library.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import dev.rishab.library.beans.Error;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {

		var error = new Error(404, ex.getMessage());
		return Response.status(Status.NOT_FOUND)
				.entity(error)
				.build();
	}

}
