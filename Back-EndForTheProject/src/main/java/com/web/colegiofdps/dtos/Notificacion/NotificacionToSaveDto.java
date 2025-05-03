package com.web.colegiofdps.dtos.Notificacion;

import com.web.colegiofdps.Entities.EstadoNotificacion;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaToSaveDto;
import com.web.colegiofdps.dtos.Acudiente.AcudienteToSaveDto;

import java.time.LocalDateTime;

public record NotificacionToSaveDto (
        String tipoNotificacion,
        String contenidoNotificacion,
        LocalDateTime fechaYhoraDeEnvio,
        EstadoNotificacion estadoNotificacion,
        PadreDeFamiliaToSaveDto padreDeFamiliaToSaveDto,
        AcudienteToSaveDto acudienteToSaveDto
){
}
