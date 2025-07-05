package unam.diplomado.pixup.colonia.api.dto;

import jakarta.inject.Singleton;
import unam.diplomado.pixup.colonia.domain.Colonia;

//lo usa la capa de apis y la tiene que inyectar el contenedor por eso la marcamos como Singleton
@Singleton
public class ColoniaMapper {

    public ColoniaDTO toDto(Colonia colonia){ //toNombreIdentidad
        return new ColoniaDTO(
                colonia.getId(),
                colonia.getNombre(),
                colonia.getCp(),
                colonia.getMunicipio().getNombre(),
                colonia.getMunicipio().getEstado().getNombre());
    }

}
