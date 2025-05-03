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
@Table(name = "PadreDeFamilia")
public class PadreDeFamilia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPadreDeFamilia;

    @Column
    private String primerNombre;

    @Column
    private String primerApellido;

    @Column
    private String segundoApellido;

    @Column
    private String email;

    @Column
    private String direccionResidencia;

    @ManyToMany
    @JoinTable(name = "estudiantesDePadresDeFamilia",
            joinColumns = @JoinColumn(name = "idPadreDeFamilia", referencedColumnName = "idPadreDeFamilia"),
            inverseJoinColumns = @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante"))
    List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "padreDeFamilia")
    private List<Notificacion> notificaciones;

    @OneToMany(mappedBy = "padreDeFamilia")
    private List<Telefono> telefonos;

    @OneToOne
    @JoinColumn(name = "documentoID_id", referencedColumnName = "idDocumentoID")
    private DocumentoIdentidad documentoIdentidad;
}
