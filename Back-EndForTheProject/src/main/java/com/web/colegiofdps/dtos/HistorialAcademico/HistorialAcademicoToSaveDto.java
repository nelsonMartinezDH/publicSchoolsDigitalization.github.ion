package com.web.colegiofdps.dtos.HistorialAcademico;

import com.web.colegiofdps.dtos.Estudiante.EstudianteToSaveDto;

import java.time.Year;

public record HistorialAcademicoToSaveDto (
        Float promedioAnteriorObtenido,
        Year añoHistorialAcademico,
        EstudianteToSaveDto estudianteToSaveDto
){
}
