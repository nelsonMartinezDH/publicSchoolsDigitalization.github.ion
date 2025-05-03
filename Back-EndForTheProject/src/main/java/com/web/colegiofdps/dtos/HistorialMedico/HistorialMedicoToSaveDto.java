package com.web.colegiofdps.dtos.HistorialMedico;

import com.web.colegiofdps.dtos.Estudiante.EstudianteToSaveDto;

public record HistorialMedicoToSaveDto (
        String EPS,
        String alergias,
        String condicionesMedicas,
        EstudianteToSaveDto estudianteToSaveDto
){
}
