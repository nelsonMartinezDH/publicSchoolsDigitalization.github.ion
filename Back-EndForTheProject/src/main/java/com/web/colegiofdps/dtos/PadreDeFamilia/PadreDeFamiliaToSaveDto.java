package com.web.colegiofdps.dtos.PadreDeFamilia;

import com.web.colegiofdps.dtos.DocumentoIdentidad.DocumentoIdentidadToSaveDto;

public record PadreDeFamiliaToSaveDto (
        String primerNombre,
        String primerApellido,
        String segundoApellido,
        String email,
        String direccionResidencia,
        DocumentoIdentidadToSaveDto documentoIdentidadToSaveDto
){
}
