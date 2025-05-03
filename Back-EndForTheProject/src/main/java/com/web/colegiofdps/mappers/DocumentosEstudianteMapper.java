package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.DocumentosEstudiante;
import com.web.colegiofdps.dtos.DocumentoIdentidad.DocumentoIdentidadToSaveDto;
import com.web.colegiofdps.dtos.DocumentosEstudiante.DocumentosEstudianteDto;
import com.web.colegiofdps.dtos.DocumentosEstudiante.DocumentosEstudianteToSaveDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocumentosEstudianteMapper {

    DocumentosEstudianteMapper mapper = Mappers.getMapper( DocumentosEstudianteMapper.class );

    @Mapping(target = "idDocumento", source = "idDocumento")
    @Mapping(target = "nombreDocumento", source = "nombreDocumento")
    @Mapping(target = "tipoDocumento", source = "tipoDocumento")
    @Mapping(target = "fechaYHoraDeCarga", source = "fechaYHoraDeCarga")
    @Mapping(target = "estadoDocumento", source = "estadoDocumento")
    @Mapping(target = "estudiante", source = "estudianteDto", ignore = true)
    DocumentosEstudiante documentosEstudiantesDtoToDocumentosEstudiantesEntity(DocumentosEstudianteDto documentosEstudianteDto);

    @InheritInverseConfiguration
    DocumentosEstudianteDto documentosEstudianteEntityToDocumentosEstudianteDto(DocumentosEstudiante documentosEstudiante);
}
