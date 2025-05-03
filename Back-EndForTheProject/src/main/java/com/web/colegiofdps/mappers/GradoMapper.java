package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.Grado;
import com.web.colegiofdps.dtos.Grado.GradoDto;
import com.web.colegiofdps.dtos.Grado.GradoToSaveDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GradoMapper {

    GradoMapper mapper = Mappers.getMapper( GradoMapper.class );

    @Mapping(target = "idGrado", source = "idGrado")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "fechaDeMatricula", source = "fechaDeMatricula")
    @Mapping(target = "estudiantes", source = "estudiantes")
    Grado gradoDtoToGradoEntity(GradoDto gradoDto);

    @InheritInverseConfiguration
    GradoDto gradoEntityToGradoDto(Grado grado);
}
