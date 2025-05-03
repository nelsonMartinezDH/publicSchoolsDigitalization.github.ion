package com.web.colegiofdps.dtos.DocumentoIdentidad;

import com.web.colegiofdps.dtos.Estudiante.EstudianteToSaveDto;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaToSaveDto;

import java.util.Date;

public record DocumentoIdentidadToSaveDto (
        String departamentoDeExpedicion,
        String municipioDeExpedicion,
        Integer numeroDocumento,
        Date fechaExpedicion,
        Date fechaExpiracion,
        PadreDeFamiliaToSaveDto padreDeFamiliaToSaveDto,
        EstudianteToSaveDto estudianteToSaveDto
){
}
