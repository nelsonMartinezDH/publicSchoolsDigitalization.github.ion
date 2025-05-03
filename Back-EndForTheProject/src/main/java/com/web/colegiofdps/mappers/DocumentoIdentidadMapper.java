package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.DocumentoIdentidad;
import com.web.colegiofdps.dtos.DocumentoIdentidad.DocumentoIdentidadDto;
import com.web.colegiofdps.dtos.DocumentoIdentidad.DocumentoIdentidadToSaveDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocumentoIdentidadMapper {

    DocumentoIdentidadMapper mapper = Mappers.getMapper( DocumentoIdentidadMapper.class );

    @Mapping(target = "idDocumentoID", source = "idDocumentoID")
    @Mapping(target = "departamentoDeExpedicion", source = "departamentoDeExpedicion")
    @Mapping(target = "municipioDeExpedicion", source = "municipioDeExpedicion")
    @Mapping(target = "numeroDocumento", source = "numeroDocumento")
    @Mapping(target = "fechaExpedicion", source = "fechaExpedicion")
    @Mapping(target = "fechaExpiracion", source = "fechaExpiracion")
    @Mapping(target = "padreDeFamilia_DocumentoID", source = "padreDeFamiliaDto", ignore = true)
    @Mapping(target = "estudiante", source = "estudianteDto", ignore = true)
    DocumentoIdentidad documentoIdentidadToDocumentoIdentidadEntity(DocumentoIdentidadDto documentoIdentidadDto);

    @InheritInverseConfiguration
    DocumentoIdentidadDto documentoIdentidadEntityToDocumentoIdentidadDto(DocumentoIdentidad documentoIdentidad);
}
