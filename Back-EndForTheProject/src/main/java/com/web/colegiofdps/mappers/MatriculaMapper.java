package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.EstadoMatricula;
import com.web.colegiofdps.Entities.Matricula;
import com.web.colegiofdps.dtos.Matricula.MatriculaDto;
import com.web.colegiofdps.dtos.Matricula.MatriculaToSaveDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MatriculaMapper {

    MatriculaMapper mapper = Mappers.getMapper( MatriculaMapper.class );

    @Mapping(target = "idMatricula", source = "idMatricula")
    @Mapping(target = "fechaMatricula", source = "fechaMatricula")
    @Mapping(target = "comentariosEnMatricula", source = "comentariosEnMatricula")
    @Mapping(target = "estadoMatricula", source = "estadoMatricula")
    @Mapping(target = "estudiante", source = "estudianteDto", ignore = true)
    Matricula matriculaDtoToMatriculaEntity(MatriculaDto matriculaDto);

    @InheritInverseConfiguration
    MatriculaDto matriculaEntityToMatriculaDto(Matricula matricula);
}
