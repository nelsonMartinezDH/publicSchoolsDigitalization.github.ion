package com.web.colegiofdps.dtos.PadreDeFamilia;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.Notificacion;
import com.web.colegiofdps.Entities.Telefono;
import com.web.colegiofdps.dtos.DocumentoIdentidad.DocumentoIdentidadDto;

import java.util.Collections;
import java.util.List;

public record PadreDeFamiliaDto (
        Long idPadreDeFamilia,
        String primerNombre,
        String primerApellido,
        String segundoApellido,
        String email,
        String direccionResidencia,
        List<Estudiante> estudiantes,
        List<Notificacion> notificacions,
        List<Telefono> telefonos,
        DocumentoIdentidadDto documentoIdentidadDto
){
    @Override
    public List<Estudiante> estudiantes() { return Collections.unmodifiableList(estudiantes); }

    @Override
    public List<Notificacion> notificacions() { return Collections.unmodifiableList(notificacions); }
    public List<Telefono> telefonos(){ return Collections.unmodifiableList(telefonos); }
}
