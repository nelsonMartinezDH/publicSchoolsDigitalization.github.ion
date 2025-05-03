package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.ColegiosAnteriores;
import com.web.colegiofdps.dtos.ColegiosAnteriores.ColegiosAnterioresDto;
import com.web.colegiofdps.dtos.ColegiosAnteriores.ColegiosAnterioresToSaveDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ColegiosMapper {

    ColegiosMapper mapper = Mappers.getMapper( ColegiosMapper.class );

    @Mapping(target = "idColegioAnterior", source = "idColegioAnterior")
    @Mapping(target = "nombreColegio", source = "nombreColegio")
    @Mapping(target = "estudiante", source = "estudianteDto", ignore = true)
    ColegiosAnteriores colegiosAnterioresDtoToColegiosAnterioresEntity(ColegiosAnterioresDto colegiosAnterioresDto);

    @InheritInverseConfiguration
    ColegiosAnterioresDto colegiosAnterioresEntityToColegiosAnterioresDto(ColegiosAnteriores colegiosAnteriores);
}
