package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.HistorialMedico;
import com.web.colegiofdps.dtos.HistorialAcademico.HistorialAcademicoToSaveDto;
import com.web.colegiofdps.dtos.HistorialMedico.HistorialMedicoDto;
import com.web.colegiofdps.dtos.HistorialMedico.HistorialMedicoToSaveDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HistorialMedicoMapper {

    HistorialAcademicoMapper mapper = Mappers.getMapper( HistorialAcademicoMapper.class );

    @Mapping(target = "idHistorialMedico", source = "idHistorialMedico")
    @Mapping(target = "EPS", source = "EPS")
    @Mapping(target = "alergias", source = "alergias")
    @Mapping(target = "condicionesMedicas", source = "condicionesMedicas")
    @Mapping(target = "estudiante", source = "estudianteDto", ignore = true)
    HistorialMedico historialMedicoDtoToHistorialMedicoEntity(HistorialMedicoDto historialMedicoDto);

    @InheritInverseConfiguration
    HistorialMedicoDto historialMedicoEntityToHistorialMedicoDto(HistorialMedico historialMedico);
}
