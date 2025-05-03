package com.web.colegiofdps.dtos.Estudiante;

import com.web.colegiofdps.Entities.Sexo;

import java.util.Date;

public record EstudianteToSaveDto (
        String primerNombre,
        String segundoNombre,
        String primerApellido,
        String segundoApellido,
        Date fechaNacimiento,
        Sexo sexoEstudiante,
        String ciudadNacimiento,
        String departamentoNacimeinto,
        String departamentoResidencia,
        String ciudadResidencia,
        String direccionResidencia,
        String email
){
}
