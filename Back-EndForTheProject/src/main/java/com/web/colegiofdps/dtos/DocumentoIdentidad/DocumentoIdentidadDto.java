package com.web.colegiofdps.dtos.DocumentoIdentidad;

import com.web.colegiofdps.dtos.Estudiante.EstudianteDto;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaDto;

import java.util.Date;

public record DocumentoIdentidadDto (
        Long idDocumentoID,
        String departamentoDeExpedicion,
        String municipioDeExpedicion,
        Integer numeroDocumento,
        Date fechaExpedicion,
        Date fechaExpiracion,
        PadreDeFamiliaDto padreDeFamiliaDto,
        EstudianteDto estudianteDto
){
}
