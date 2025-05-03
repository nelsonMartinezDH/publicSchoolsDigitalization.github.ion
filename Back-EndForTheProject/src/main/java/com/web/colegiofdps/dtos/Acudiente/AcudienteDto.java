package com.web.colegiofdps.dtos.Acudiente;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.Notificacion;

import java.util.Collections;
import java.util.List;

public record AcudienteDto (
        Long idAcudiente,
        String primerNombre,
        String primerApellido,
        String segundoApellido,
        String email,
        String ocupacion,
        List<Estudiante> estudiantes,
        List<Notificacion> notificacions
        )
{
    public List<Estudiante> estudiantes(){ return Collections.unmodifiableList(estudiantes); }
    public List<Notificacion> notificacions(){ return Collections.unmodifiableList(notificacions); }
}
