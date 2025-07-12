package unam.diplomado.pixup.usuario.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroUsuarioDTO {

    @NotNull(message = "Usuario es requerido para realizar el registro")
    @Valid //barre todas las validaciones de esta clase y de las clases de los objetos que se encuentran aqui (usuario y domicilio)
    private UsuarioRequestDTO usuario;

    @NotNull(message = "Domicilio es requerido para realizar el registro")
    @Valid
    private DomicilioDTO domicilio;

}
