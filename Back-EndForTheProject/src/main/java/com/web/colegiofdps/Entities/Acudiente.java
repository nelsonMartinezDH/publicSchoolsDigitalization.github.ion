package com.web.colegiofdps.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "Acudiente")
public class Acudiente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAcudiente;

    @Column
    private String primerNombre;

    @Column
    private String primerApellido;

    @Column
    private String segundoApellido;

    @Column
    private String email;

    @Column
    private String ocupacion;

    @ManyToMany
    @JoinTable(name = "acudientesDeEstudiantes",
            joinColumns = @JoinColumn(name = "acudienteID", referencedColumnName = "idAcudiente"),
            inverseJoinColumns = @JoinColumn(name = "estudianteID", referencedColumnName = "idEstudiante"))
    List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "acudiente")
    private List<Notificacion> notificaciones;
}
