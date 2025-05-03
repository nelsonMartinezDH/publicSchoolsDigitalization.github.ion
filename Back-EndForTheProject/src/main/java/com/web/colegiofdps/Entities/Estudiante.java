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
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEstudiante;

    @Column
    private String primerNombre;

    @Column
    private String segundoNombre;

    @Column
    private String primerApellido;

    @Column
    private String segundoApellido;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column
    @Enumerated(EnumType.STRING)
    private Sexo sexoEstudiante;

    @Column
    private String ciudadNacimiento;

    @Column
    private String departamentoNacimiento;

    @Column
    private String departamentoResidencia;

    @Column
    private String ciudadResidencia;

    @Column
    private String direccionResidencia;

    @Column
    private String email;

    @ManyToMany(mappedBy = "estudiantes")
    List<PadreDeFamilia> padresDeFamilia;

    @OneToMany(mappedBy = "estudiante")
    private List<DocumentosEstudiante> documentosEstudiante;

    @OneToMany(mappedBy = "estudiante")
    private List<Telefono> telefonos;

    @OneToMany(mappedBy = "estudiante")
    private List<ColegiosAnteriores> colegiosAnteriores;

    @OneToOne
    @JoinColumn(name = "matriculaID", referencedColumnName = "idMatricula")
    private Matricula matricula;

    @OneToOne
    @JoinColumn(name = "historialMedicoID", referencedColumnName = "idHistorialMedico")
    private HistorialMedico historialMedico;

    @ManyToMany(mappedBy = "estudiantes")
    List<Acudiente> acudientes;

    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.REMOVE)
    private HistorialAcademico historialAcademico;

    @OneToOne
    @JoinColumn(name = "documentoID_id", referencedColumnName = "idDocumentoID")
    private DocumentoIdentidad documentoIdentidad;

    @ManyToMany(mappedBy = "estudiantes")
    List<Grado> grados;

    @ManyToMany(mappedBy = "estudiantes")
    List<CitaPsicologica> citasPsicologicas;
}
