package unam.diplomado.pixup.colonia.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.api.dto.ColoniaDTO;
import unam.diplomado.pixup.colonia.domain.Colonia;

import java.util.Collection;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("colonias")
public interface ColoniaApi {

    @GET
    @Path("{id}")
    Colonia getColoniaById(@PathParam("id") Integer id);

    @GET
    Collection<ColoniaDTO> getColoniasByCp(
            @NotBlank @QueryParam("cp") String cp);

    @DELETE
    @Path("{id}")
    void deleteColonia(@PathParam("id") Integer id);

    @POST
    Response createColonia(@NotNull @Valid Colonia colonia);

    @PUT
    @Path("{id}")
    Colonia updateColonia(@PathParam("id") Integer id, Colonia colonia);

}