package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.Notificacion;
import com.web.colegiofdps.dtos.Notificacion.NotificacionDto;
import com.web.colegiofdps.dtos.Notificacion.NotificacionToSaveDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NotificacionMapper {

    NotificacionMapper mapper = Mappers.getMapper( NotificacionMapper.class );

    @Mapping(target = "idNotificacion", source = "idNotificacion")
    @Mapping(target = "tipoNotificacion", source = "tipoNotificacion")
    @Mapping(target = "contenidoNotificacion", source = "contenidoNotificacion")
    @Mapping(target = "fechaYHoraDeEnvio", source = "fechaYHoraDeEnvio")
    @Mapping(target = "estadoNotificacion", source = "estadoNotificacion")
    @Mapping(target = "padreDeFamilia", source = "padreDeFamiliaDto", ignore = true)
    @Mapping(target = "acudiente", source = "acudienteDto", ignore = true)
    Notificacion notificacionDtoToNotificacionEntity(NotificacionDto notificacionDto);

    @InheritInverseConfiguration
    NotificacionDto notificacionEntityToNotificacionDto(Notificacion notificacion);
}
