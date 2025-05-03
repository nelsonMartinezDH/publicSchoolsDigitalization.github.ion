package com.web.colegiofdps.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "Matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMatricula;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaMatricula;

    @Column
    private String comentariosEnMatricula;

    @Column
    @Enumerated(EnumType.STRING)
    private EstadoMatricula estadoMatricula;

    @OneToOne(mappedBy = "matricula", cascade = CascadeType.REMOVE)
    private Estudiante estudiante;


}
