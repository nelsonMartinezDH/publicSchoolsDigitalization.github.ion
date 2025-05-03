package com.web.colegiofdps.dtos.ColegiosAnteriores;

import com.web.colegiofdps.dtos.Estudiante.EstudianteDto;

public record ColegiosAnterioresDto (
        Long idColegioAnterior,
        String nombreColegio,
        EstudianteDto estudianteDto
){
}
