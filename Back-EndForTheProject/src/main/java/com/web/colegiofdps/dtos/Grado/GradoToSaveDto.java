package com.web.colegiofdps.dtos.Grado;

import java.util.Date;

public record GradoToSaveDto (
        String nombre,
        Date fechaDeMatricula
){
}
