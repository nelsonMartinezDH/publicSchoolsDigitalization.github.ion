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
@Table(name = "Notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNotificacion;

    @Column
    private String tipoNotificacion;

    @Column
    private String contenidoNotificacion;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaYHoraDeEnvio;

    @Column
    @Enumerated(EnumType.STRING)
    private EstadoNotificacion estadoNotificacion;

    @ManyToOne
    @JoinColumn(name = "idPadreDeFamilia", referencedColumnName = "idPadreDeFamilia")
    private PadreDeFamilia padreDeFamilia;

    @ManyToOne
    @JoinColumn(name = "acudienteID", referencedColumnName = "idAcudiente")
    private Acudiente acudiente;
}
