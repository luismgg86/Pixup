package unam.diplomado.pixup.disco.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cancion")
public class Cancion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private LocalTime duracion;
    @ManyToOne(targetEntity = Disco.class)
    @JoinColumn(name = "id_disco", nullable = false)
    private Disco disco;
}
