package com.web.colegiofdps.dtos.Notificacion;

import com.web.colegiofdps.Entities.EstadoNotificacion;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaDto;
import com.web.colegiofdps.dtos.Acudiente.AcudienteDto;

import java.time.LocalDateTime;

public record NotificacionDto (
        Long idNotificacion,
        String tipoNotificacion,
        String contenidoNotificacion,
        LocalDateTime fechaYHoraDeEnvio,
        EstadoNotificacion estadoNotificacion,
        PadreDeFamiliaDto padreDeFamiliaDto,
        AcudienteDto acudienteDto
){
}
