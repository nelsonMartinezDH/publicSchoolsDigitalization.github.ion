package com.web.colegiofdps.dtos.HistorialAcademico;

import com.web.colegiofdps.dtos.Estudiante.EstudianteDto;

import java.time.Year;

public record HistorialAcademicoDto (
        Long idHistorialAcademico,
        Float promedioAnteriorObtenido,
        Year añoHistorialAcademico,
        EstudianteDto estudianteDto
){
}
