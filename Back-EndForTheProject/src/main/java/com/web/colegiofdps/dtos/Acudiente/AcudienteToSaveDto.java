package com.web.colegiofdps.dtos.Acudiente;

public record AcudienteToSaveDto (
        String primerNombre,
        String primerApellido,
        String segundoApellido,
        String email,
        String ocupacion
){
}
