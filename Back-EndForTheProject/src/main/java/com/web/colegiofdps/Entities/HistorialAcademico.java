package com.web.colegiofdps.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "Historial Academico")
public class HistorialAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHistorialAcademico;

    @Column
    private Float promedioAnteriorObtenido;

    @Column
    private Year añoHistorialAcademico;

    @OneToOne
    @JoinColumn(name = "estudianteID", referencedColumnName = "idEstudiante")
    private Estudiante estudiante;
}
