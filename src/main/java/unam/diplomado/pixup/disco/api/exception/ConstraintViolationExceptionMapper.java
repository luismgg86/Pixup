package unam.diplomado.pixup.disco.api.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                //.entity(e.getMessage())
                .entity(new ErrorResponse(
                        Response.Status.BAD_REQUEST.getStatusCode(),
                        "WRONG_INPUT",
                        e.getMessage()))
                .build();
    }

}
