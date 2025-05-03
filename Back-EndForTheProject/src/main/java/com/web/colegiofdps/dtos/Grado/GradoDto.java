package com.web.colegiofdps.dtos.Grado;

import com.web.colegiofdps.Entities.Estudiante;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public record GradoDto (
        Long idGrado,
        String nombre,
        Date fechaDeMatricula,
        List<Estudiante> estudiantes
){
    @Override
    public List<Estudiante> estudiantes() { return Collections.unmodifiableList(estudiantes); }
}
