package unam.diplomado.pixup.usuario.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;

import java.util.Collection;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("tiposDomicilio")
public interface TipoDomicilioApi {

    @GET
    Collection<TipoDomicilio> getAll();

}