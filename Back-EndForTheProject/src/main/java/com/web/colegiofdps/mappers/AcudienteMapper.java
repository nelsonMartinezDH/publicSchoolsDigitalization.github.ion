package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.Acudiente;
import com.web.colegiofdps.dtos.Acudiente.AcudienteDto;
import com.web.colegiofdps.dtos.Acudiente.AcudienteToSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AcudienteMapper {

    AcudienteMapper mapper = Mappers.getMapper( AcudienteMapper.class );

    @Mapping(source = "idAcudiente", target = "idAcudiente")
    @Mapping(source = "primerNombre", target = "primerNombre")
    @Mapping(source = "primerApellido", target = "primerApellido")
    @Mapping(source = "segundoApellido", target = "segundoApellido")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "ocupacion", target = "ocupacion")
    @Mapping(source = "estudiantes", target = "estudiantes")
    @Mapping(source = "notificacions", target = "notificaciones")
    Acudiente acudienteDtoToAcudienteEntity(AcudienteDto acudienteDto);

    @Mapping(source = "idAcudiente", target = "idAcudiente")
    @Mapping(source = "primerNombre", target = "primerNombre")
    @Mapping(source = "primerApellido", target = "primerApellido")
    @Mapping(source = "segundoApellido", target = "segundoApellido")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "ocupacion", target = "ocupacion")
    @Mapping(source = "estudiantes", target = "estudiantes")
    @Mapping(source = "notificaciones", target = "notificacions")
    AcudienteDto acudienteEntityToAcudienteDto(Acudiente acudiente);
}
