package com.web.colegiofdps.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "Documentos De Estudiante")
public class DocumentosEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDocumento;

    @Column
    private String nombreDocumento;

    @Column
    private String tipoDocumento;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaYHoraDeCarga;

    @Column
    @Enumerated(EnumType.STRING)
    private EstadoDocumento estadoDocumento;

    @ManyToOne
    @JoinColumn(name = "estudianteID", referencedColumnName = "idEstudiante")
    private Estudiante estudiante;
}
