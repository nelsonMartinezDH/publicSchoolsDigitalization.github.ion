package com.web.colegiofdps.dtos.DocumentosEstudiante;

import com.web.colegiofdps.Entities.EstadoDocumento;
import com.web.colegiofdps.dtos.Estudiante.EstudianteToSaveDto;

import java.time.LocalDateTime;

public record DocumentosEstudianteToSaveDto (
        String nombreDocumento,
        String tipoDocumento,
        LocalDateTime fechaYHoraDeCarga,
        EstadoDocumento estadoDocumento,
        EstudianteToSaveDto estudianteToSaveDto
){
}
