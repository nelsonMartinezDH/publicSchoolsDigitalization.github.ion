package com.web.colegiofdps.dtos.Telefono;

import com.web.colegiofdps.Entities.TipoTelefono;
import com.web.colegiofdps.dtos.Estudiante.EstudianteToSaveDto;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaToSaveDto;

public record TelefonoToSaveDto (
        TipoTelefono tipoTelefono,
        String numeroTelefonico,
        EstudianteToSaveDto estudianteToSaveDto,
        PadreDeFamiliaToSaveDto padreDeFamiliaToSaveDto
){
}
