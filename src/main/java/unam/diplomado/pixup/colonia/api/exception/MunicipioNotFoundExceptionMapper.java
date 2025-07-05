package unam.diplomado.pixup.colonia.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.colonia.domain.MunicipioNotFoundException;

@Provider //indica al contenedor que es el responsable, mediante un demonioi que monitorea cuando se lanza una excepcion de este tipo
public class MunicipioNotFoundExceptionMapper implements ExceptionMapper<MunicipioNotFoundException> {

    @Override
    public Response toResponse(MunicipioNotFoundException e) {
        return Response
                .status(Response.Status.PRECONDITION_REQUIRED)
                .entity(e.getMessage())
                .build();
    }
}
