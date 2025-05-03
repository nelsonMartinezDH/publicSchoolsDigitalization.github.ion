package com.web.colegiofdps.services.documentosEstudiante;

import com.web.colegiofdps.Entities.DocumentosEstudiante;
import com.web.colegiofdps.Entities.EstadoDocumento;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.DocumentosEstudiante.DocumentosEstudianteDto;
import com.web.colegiofdps.dtos.DocumentosEstudiante.DocumentosEstudianteToSaveDto;

import java.util.List;

public interface DocumentosEstudianteService {
    DocumentosEstudianteDto saveDocumentosEstudiante(DocumentosEstudianteDto documentosEstudiante);
    DocumentosEstudianteDto updateDocumentosEstudianteById(Long id, DocumentosEstudianteDto documentosEstudiante);
    DocumentosEstudianteDto findDocumentosEstudianteById(Long id);
    List<DocumentosEstudianteDto> findAllDocumentosEstudiante();
    void deleteDocumentosEstudianteById(Long id);
    DocumentosEstudianteDto findDocumentosEstudianteByNombreDocumento(String nombreDocumento);
    DocumentosEstudianteDto findDocumentosEstudianteByEstudiante(Estudiante estudiante);
    List<DocumentosEstudianteDto> findDocumentosEstudianteByTipoDocumento(String tipoDocumentos);
    List<DocumentosEstudianteDto> findDocumentosEstudianteByEstadoDocumento(EstadoDocumento estadoDocumento);
}
