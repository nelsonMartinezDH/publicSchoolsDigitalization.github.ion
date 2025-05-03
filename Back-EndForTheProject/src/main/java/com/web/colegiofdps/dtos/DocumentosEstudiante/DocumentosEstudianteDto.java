package com.web.colegiofdps.dtos.DocumentosEstudiante;

import com.web.colegiofdps.Entities.EstadoDocumento;
import com.web.colegiofdps.dtos.Estudiante.EstudianteDto;

import java.time.LocalDateTime;

public record DocumentosEstudianteDto (
        Long idDocumento,
        String nombreDocumento,
        String tipoDocumento,
        LocalDateTime fechaYHoraDeCarga,
        EstadoDocumento estadoDocumento,
        EstudianteDto estudianteDto
){
}
