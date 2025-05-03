package com.web.colegiofdps.dtos.Telefono;

import com.web.colegiofdps.Entities.TipoTelefono;
import com.web.colegiofdps.dtos.Estudiante.EstudianteDto;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaDto;

public record TelefonoDto (
        Long idTelefono,
        TipoTelefono tipoTelefono,
        String numeroTelefonico,
        EstudianteDto estudianteDto,
        PadreDeFamiliaDto padreDeFamiliaDto
){
}
