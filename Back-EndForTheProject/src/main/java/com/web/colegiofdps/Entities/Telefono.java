package com.web.colegiofdps.Entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "Telefono")
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTelefono;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoTelefono tipoTelefono;

    @Column
    private String numeroTelefonico;

    @ManyToOne
    @JoinColumn(name = "estudianteID", referencedColumnName = "idEstudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "padreDeFamiliaID", referencedColumnName = "idPadreDeFamilia")
    private PadreDeFamilia padreDeFamilia;
}
