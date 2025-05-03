package com.web.colegiofdps.dtos.ColegiosAnteriores;

import com.web.colegiofdps.dtos.Estudiante.EstudianteToSaveDto;

public record ColegiosAnterioresToSaveDto (
        String nombreColegio,
        EstudianteToSaveDto estudianteToSaveDto
){
}
