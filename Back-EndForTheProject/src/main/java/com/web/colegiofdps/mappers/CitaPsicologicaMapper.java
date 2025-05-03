package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.CitaPsicologica;
import com.web.colegiofdps.dtos.CitaPsicologica.CitaPsicologicaDto;
import com.web.colegiofdps.dtos.CitaPsicologica.CitaPsicologicaToSaveDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CitaPsicologicaMapper {

    CitaPsicologicaMapper mapper = Mappers.getMapper( CitaPsicologicaMapper.class );

    @Mapping(target = "idCitaPsicologica", source = "idCitaPsicologica")
    @Mapping(target = "fechaYHoraDeCita", source = "fecha_HoraDeCita")
    @Mapping(target = "motivoCita", source = "motivoCita")
    @Mapping(target = "estadoCitaPsicologica", source = "estadoCitaPsicologica")
    @Mapping(target = "estudiantes", source = "estudiantes")
    CitaPsicologica citaPsicologicaDtoToCitaPsicologicaEntity(CitaPsicologicaDto citaPsicologicaDto);

    @InheritInverseConfiguration
    CitaPsicologicaDto citaPsicologicaEntityToCitaPsicologicaDto(CitaPsicologica citaPsicologica);
}
