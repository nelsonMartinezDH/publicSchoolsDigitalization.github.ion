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
@Table(name = "Documento De Identidad")
public class DocumentoIdentidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDocumentoID;

    @Column
    private String departamentoDeExpedicion;

    @Column
    private String municipioDeExpedicion;

    @Column
    private Integer numeroDocumento;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaExpiracion;

    @OneToOne(mappedBy = "documentoIdentidad", cascade = CascadeType.REMOVE)
    private PadreDeFamilia padreDeFamilia_DocumentoID;

    @OneToOne(mappedBy = "documentoIdentidad", cascade = CascadeType.REMOVE)
    private Estudiante estudiante;
}
