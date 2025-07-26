package unam.diplomado.pixup.disco.domain;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table
public class Disco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Titulo es requerido")
    private String titulo;

    private Double precio;
    private Integer existencia;
    private Double descuento;

    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    @Column(name="fecha_lanzamiento")
    private LocalDateTime fechaLanzamiento;

    @Pattern(regexp = "^.+\\.(jpg|jpeg|png|gif)$", message = "La imagen debe terminar en .jpg, .jpeg, .png o .gif")
    private String imagen;

    @ManyToOne(targetEntity= Artista.class)
    @JoinColumn(name="id_artista", nullable=false)
    private Artista artista;
    @ManyToOne(targetEntity = Disquera.class)
    @JoinColumn(name="id_disquera",nullable=false)
    private Disquera disquera;
    @ManyToOne(targetEntity = GeneroMusical.class)
    @JoinColumn(name="id_genero_musical",nullable = false)
    private GeneroMusical generoMusical;
}
