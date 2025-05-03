package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.HistorialAcademico;
import com.web.colegiofdps.dtos.HistorialAcademico.HistorialAcademicoDto;
import com.web.colegiofdps.dtos.HistorialAcademico.HistorialAcademicoToSaveDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HistorialAcademicoMapper {

    HistorialAcademicoMapper mapper = Mappers.getMapper( HistorialAcademicoMapper.class );

    @Mapping(target = "idHistorialAcademico", source = "idHistorialAcademico")
    @Mapping(target = "promedioAnteriorObtenido", source = "promedioAnteriorObtenido")
    @Mapping(target = "añoHistorialAcademico", source = "añoHistorialAcademico")
    @Mapping(target = "estudiante", source = "estudianteDto", ignore = true)
    HistorialAcademico historialAcademicoDtoToHistorialAcademicoEntity(HistorialAcademicoDto historialAcademicoDto);

    @InheritInverseConfiguration
    HistorialAcademicoDto historialAcademicoEntityToHistorialAcademicoDto(HistorialAcademico historialAcademico);
}
