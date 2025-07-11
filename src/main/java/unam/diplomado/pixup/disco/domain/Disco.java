package unam.diplomado.pixup.disco.domain;

import jakarta.persistence.*;
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
    private String titulo;
    private Double precio;
    private Integer existencia;
    private Double descuento;
    @Column(name="fecha_lanzamiento")
    private LocalDateTime fechaLanzamiento;
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
