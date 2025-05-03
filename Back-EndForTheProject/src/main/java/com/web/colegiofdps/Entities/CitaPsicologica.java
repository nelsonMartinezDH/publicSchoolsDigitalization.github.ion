package com.web.colegiofdps.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "citaPsicologica")
public class CitaPsicologica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCitaPsicologica;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaYHoraDeCita;

    @Column
    private String motivoCita;

    @Column
    @Enumerated(EnumType.STRING)
    private EstadoCitaPsicologica estadoCitaPsicologica;

    @ManyToMany
    @JoinTable(name = "citaPsicologicaDeEstudiantes",
            joinColumns = @JoinColumn(name = "citaPsicologicaID", referencedColumnName = "idCitaPsicologica"),
            inverseJoinColumns = @JoinColumn(name = "estudianteID", referencedColumnName = "idEstudiante"))
    List<Estudiante> estudiantes;
}
