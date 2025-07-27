package unam.diplomado.pixup.disco.api.dto;

import jakarta.inject.Singleton;
import unam.diplomado.pixup.disco.domain.Disco;

@Singleton
public class DiscoMapper {

    public DiscoResponseDTO toDto(Disco disco){
        return new DiscoResponseDTO(disco.getId(), disco.getTitulo());
    }

    public Disco toDisco(DiscoRequestDTO discoRequestDTO){
        return new Disco(
                discoRequestDTO.getTitulo(),discoRequestDTO.getPrecio(),
                discoRequestDTO.getExistencia(), discoRequestDTO.getDescuento(),
                discoRequestDTO.getFechaLanzamiento(), discoRequestDTO.getImagen(),
                discoRequestDTO.getArtista(),discoRequestDTO.getDisquera(),
                discoRequestDTO.getGeneroMusical());
    }

}
