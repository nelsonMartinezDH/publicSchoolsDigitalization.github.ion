package com.web.colegiofdps.dtos.CitaPsicologica;

import com.web.colegiofdps.Entities.EstadoCitaPsicologica;

import java.time.LocalDateTime;

public record CitaPsicologicaToSaveDto (
        LocalDateTime fechaYHoraDeCita,
        String motivoCita,
        EstadoCitaPsicologica estadoCitaPsicologica
){
}
