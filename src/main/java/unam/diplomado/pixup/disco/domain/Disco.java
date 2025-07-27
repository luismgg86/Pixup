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

    public Disco(
            String titulo,
            Double precio,
            Integer existencia,
            Double descuento,
            LocalDateTime fechaLanzamiento,
            String imagen,
            Integer idArtista,
            Integer idDisquera,
            Integer idGeneroMusical
    ) {
        this.titulo = titulo;
        this.precio = precio;
        this.existencia = existencia;
        this.descuento = descuento;
        this.fechaLanzamiento = fechaLanzamiento;
        this.imagen = imagen;
        this.artista = new Artista();
        this.artista.setId(idArtista);
        this.disquera =  new Disquera();
        this.disquera.setId(idDisquera);
        this.generoMusical = new GeneroMusical();
        this.generoMusical.setId(idGeneroMusical);
    }


}
