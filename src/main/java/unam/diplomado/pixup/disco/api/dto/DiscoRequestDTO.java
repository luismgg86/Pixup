package unam.diplomado.pixup.disco.api.dto;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscoRequestDTO {

    @NotBlank(message = "Titulo es requerido")
    private String titulo;
    @Min(value = 0, message = "El precio no puede ser negativo")
    private Double precio;
    @Min(value = 0, message = "La existencia no puede ser negativa")
    private Integer existencia;
    private Double descuento;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaLanzamiento;
    @Pattern(regexp = "^.+\\.(jpg|jpeg|png|gif)$", message = "La imagen debe terminar en .jpg, .jpeg, .png o .gif")
    private String imagen;
    @NotNull(message = "Artista es requerido")
    private Integer artista;
    @NotNull(message = "Disquera es requerido")
    private Integer disquera;
    @NotNull(message = "Genero musical es requerido")
    private Integer generoMusical;

}
