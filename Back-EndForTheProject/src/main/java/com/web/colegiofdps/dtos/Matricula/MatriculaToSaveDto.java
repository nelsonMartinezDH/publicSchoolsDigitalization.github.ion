package com.web.colegiofdps.dtos.Matricula;

import com.web.colegiofdps.Entities.EstadoMatricula;
import com.web.colegiofdps.dtos.Estudiante.EstudianteToSaveDto;

import java.util.Date;

public record MatriculaToSaveDto (
        Date fechaMatricula,
        String comentariosEnMatricula,
        EstadoMatricula estadoMatricula,
        EstudianteToSaveDto estudianteToSaveDto
){
}
