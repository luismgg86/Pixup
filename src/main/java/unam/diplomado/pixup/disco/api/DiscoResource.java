package unam.diplomado.pixup.disco.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.api.dto.DiscoMapper;
import unam.diplomado.pixup.disco.api.dto.DiscoRequestDTO;
import unam.diplomado.pixup.disco.api.dto.DiscoResponseDTO;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.domain.DiscoAlreadyExistsException;
import unam.diplomado.pixup.disco.service.DiscoService;

public class DiscoResource implements DiscoApi{
    @Inject
    private DiscoService discoService;

    @Inject
    private DiscoMapper mapper;

    @Override
    public Response altaDisco(DiscoRequestDTO discoRequestDTO) {

        Disco disco = mapper.toDisco(discoRequestDTO);

        Disco discoCreado = discoService.registrarDisco(disco);

        DiscoResponseDTO discoResponseDTO = mapper.toDto(discoCreado);

        return Response
                .status(Response.Status.CREATED)
                .entity(discoResponseDTO)
                .build();
    }

}
