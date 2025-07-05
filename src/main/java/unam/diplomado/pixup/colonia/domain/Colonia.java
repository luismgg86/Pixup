package unam.diplomado.pixup.colonia.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Colonia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nombre es requerido") //se aplica sobre la entidad del modelo persistente (Entity)
    private String nombre;

    @Pattern(regexp="^(\\d{5})$", message = "Formato no valido para código postal") //expresion regular para validar el formato
    private String cp;

    @ManyToOne(targetEntity = Municipio.class)
    @JoinColumn(name = "id_municipio", nullable = false)
    @NotNull(message = "La colonia debe estar asociada a un municipio") //No puede venir nulo
    private Municipio municipio;

}