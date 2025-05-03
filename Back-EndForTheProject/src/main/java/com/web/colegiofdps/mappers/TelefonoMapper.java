package com.web.colegiofdps.mappers;

import com.web.colegiofdps.dtos.Telefono.TelefonoDto;
import com.web.colegiofdps.Entities.Telefono;
import com.web.colegiofdps.dtos.Telefono.TelefonoToSaveDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TelefonoMapper {

    TelefonoMapper mapper = Mappers.getMapper( TelefonoMapper.class );

    @Mapping(target = "idTelefono", source = "idTelefono")
    @Mapping(target = "tipoTelefono", source = "tipoTelefono")
    @Mapping(target = "numeroTelefonico", source = "numeroTelefonico")
    @Mapping(target = "estudiante", source = "estudianteDto", ignore = true)
    @Mapping(target = "padreDeFamilia", source = "padreDeFamiliaDto", ignore = true)
    Telefono phoneDtoToPhoneEntity(TelefonoDto telefonoDto);

    @InheritInverseConfiguration
    TelefonoDto phoneEntityToPhoneDto(Telefono telefono);
}
