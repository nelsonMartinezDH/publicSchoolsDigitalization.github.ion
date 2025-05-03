package com.web.colegiofdps.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "Grado")
public class Grado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGrado;

    @Column
    private String nombre;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaDeMatricula;

    @ManyToMany
    @JoinTable(name = "gradoDeEstudiante",
            joinColumns = @JoinColumn(name = "gradoID", referencedColumnName = "idGrado"),
            inverseJoinColumns = @JoinColumn(name = "estudianteID", referencedColumnName = "idEstudiante"))
    List<Estudiante> estudiantes;
}
