package unam.diplomado.pixup.usuario.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pixup.colonia.domain.Colonia;

@Data
@NoArgsConstructor
@Entity
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String calle;
    @Column(name = "num_exterior")
    private String numExterior;
    @Column(name = "num_interior")
    private String numInterior;
    @ManyToMany(targetEntity = Colonia.class)
    @JoinColumn(name="id_colonia", nullable = false)
    private Colonia colonia;
    @ManyToMany(targetEntity = Usuario.class)
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;
    @ManyToMany(targetEntity = TipoDomicilio.class)
    @JoinColumn(name="id_tipo_domicilio", nullable = false)
    private TipoDomicilio tipoDomicilio;

}
