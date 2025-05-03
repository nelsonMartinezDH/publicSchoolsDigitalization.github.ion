package com.web.colegiofdps.services.documentoIdentidad;

import com.web.colegiofdps.Entities.DocumentoIdentidad;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.PadreDeFamilia;
import com.web.colegiofdps.dtos.DocumentoIdentidad.DocumentoIdentidadDto;
import com.web.colegiofdps.dtos.DocumentoIdentidad.DocumentoIdentidadToSaveDto;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DocumentoIdentidadService {
    DocumentoIdentidadDto saveDocumentoIdentidad(DocumentoIdentidadDto documentoIdentidad);
    DocumentoIdentidadDto updateDocumentoIdentidadByid(Long id, DocumentoIdentidadDto documentoIdentidad);
    DocumentoIdentidadDto findDocumentoIdentidadById(Long id);
    List<DocumentoIdentidadDto> findAllDocumentoIdentidad();
    void deleteDocumentoIdentidadById(Long id);
    DocumentoIdentidadDto findDocumentoIdentidadByNumeroDocumento(Integer numeroDocumento);
    List<DocumentoIdentidadDto> findDocumentoIdentidadByFechaDeExpedicion(Date fechaExpedicion);
    DocumentoIdentidadDto findDocumentoIdentidadByEstudiante(Estudiante estudiante);
}
