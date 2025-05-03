package com.web.colegiofdps.Entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "HistorialMedico")
public class HistorialMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHistorialMedico;

    @Column
    private String EPS;

    @Column
    private String alergias;

    @Column
    private String condicionesMedicas;

    @OneToOne(mappedBy = "historialMedico", cascade = CascadeType.REMOVE)
    private Estudiante estudiante;
}
