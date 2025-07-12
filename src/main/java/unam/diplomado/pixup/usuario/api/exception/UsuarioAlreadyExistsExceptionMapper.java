package unam.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import unam.diplomado.pixup.usuario.domain.UsuarioAlreadyExistsException;

public class UsuarioAlreadyExistsExceptionMapper implements ExceptionMapper<UsuarioAlreadyExistsException>{
    @Override
    public Response toResponse(UsuarioAlreadyExistsException e) {
        return Response
                .status(Response.Status.CONFLICT)
                //.entity(e.getMessage())
                .entity(new ErrorResponse(
                        Response.Status.CONFLICT.getStatusCode(),
                        "BUSINESS_RULE",
                         e.getMessage()))
                .build();
    }
}
