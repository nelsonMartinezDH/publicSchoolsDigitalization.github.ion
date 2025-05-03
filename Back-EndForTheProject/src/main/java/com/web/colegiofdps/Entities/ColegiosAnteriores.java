package com.web.colegiofdps.Entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "Colegios Anteriores")
public class ColegiosAnteriores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idColegioAnterior;

    @Column
    private String nombreColegio;

    @ManyToOne
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante")
    private Estudiante estudiante;
}
