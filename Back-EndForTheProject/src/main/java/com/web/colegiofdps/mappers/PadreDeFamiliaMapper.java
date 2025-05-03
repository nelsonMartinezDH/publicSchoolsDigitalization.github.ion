package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.PadreDeFamilia;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaDto;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaToSaveDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PadreDeFamiliaMapper {

    PadreDeFamiliaMapper mapper = Mappers.getMapper( PadreDeFamiliaMapper.class );

    @Mapping(target = "idPadreDeFamilia", source = "idPadreDeFamilia")
    @Mapping(target = "primerNombre", source = "primerNombre")
    @Mapping(target = "primerApellido", source = "primerApellido")
    @Mapping(target = "segundoApellido", source = "segundoApellido")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "direccionResidencia", source = "direccionResidencia")
    @Mapping(target = "estudiantes", source = "estudiantes")
    @Mapping(target = "notificaciones", source = "notificacions")
    @Mapping(target = "telefonos", source = "telefonos")
    @Mapping(target = "documentoIdentidad", source = "documentoIdentidadDto", ignore = true)
    PadreDeFamilia parentDtoToParentEntity(PadreDeFamiliaDto padreDeFamiliaDto);

    @InheritInverseConfiguration
    PadreDeFamiliaDto parentEntityToParentDto(PadreDeFamilia padreDeFamilia);
}
