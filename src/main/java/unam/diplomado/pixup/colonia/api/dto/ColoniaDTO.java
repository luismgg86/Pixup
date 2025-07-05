package unam.diplomado.pixup.colonia.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Crea los setters, getters, to_string etc.
@NoArgsConstructor
@AllArgsConstructor
public class ColoniaDTO {

    Integer id;
    private String nombre;
    private String cp;
    private String municipio;
    private String estado;

}
