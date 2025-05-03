package com.web.colegiofdps.dtos.HistorialMedico;

import com.web.colegiofdps.dtos.Estudiante.EstudianteDto;

public record HistorialMedicoDto (
        Long idHistorialMedico,
        String EPS,
        String alergias,
        String condicionesMedicas,
        EstudianteDto estudianteDto
){
}
