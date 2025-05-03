package com.web.colegiofdps.dtos.CitaPsicologica;

import com.web.colegiofdps.Entities.EstadoCitaPsicologica;
import com.web.colegiofdps.Entities.Estudiante;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public record CitaPsicologicaDto (
        Long idCitaPsicologica,
        LocalDateTime fecha_HoraDeCita,
        String motivoCita,
        EstadoCitaPsicologica estadoCitaPsicologica,
        List<Estudiante> estudiantes
){
    public List<Estudiante> estudiantes(){ return Collections.unmodifiableList(estudiantes); }
}
