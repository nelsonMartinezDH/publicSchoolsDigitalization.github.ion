package com.web.colegiofdps.dtos.Matricula;

import com.web.colegiofdps.Entities.EstadoMatricula;
import com.web.colegiofdps.dtos.Estudiante.EstudianteDto;

import java.util.Date;

public record MatriculaDto (
        Long idMatricula,
        Date fechaMatricula,
        String comentariosEnMatricula,
        EstadoMatricula estadoMatricula,
        EstudianteDto estudianteDto
){
}
