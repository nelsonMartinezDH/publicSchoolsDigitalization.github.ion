package com.web.colegiofdps.services.documentosEstudiante;

import com.web.colegiofdps.Entities.DocumentosEstudiante;
import com.web.colegiofdps.Entities.EstadoDocumento;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.DocumentosEstudiante.DocumentosEstudianteDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.DocumentosEstudianteMapper;
import com.web.colegiofdps.repositories.DocumentosEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentosEstudianteServiceImpl implements DocumentosEstudianteService{

    private final DocumentosEstudianteRepository documentosEstudianteRepository;

    private final DocumentosEstudianteMapper documentosEstudianteMapper;

    @Autowired
    public DocumentosEstudianteServiceImpl(DocumentosEstudianteRepository documentosEstudianteRepository,
                                           DocumentosEstudianteMapper documentosEstudianteMapper) {
        this.documentosEstudianteRepository = documentosEstudianteRepository;
        this.documentosEstudianteMapper = documentosEstudianteMapper;
    }

    @Override
    public DocumentosEstudianteDto saveDocumentosEstudiante(DocumentosEstudianteDto documentosEstudiante) {
        DocumentosEstudiante DEToSave = documentosEstudianteMapper.documentosEstudiantesDtoToDocumentosEstudiantesEntity(documentosEstudiante);
        DocumentosEstudiante DESaved = documentosEstudianteRepository.save(DEToSave);
        return documentosEstudianteMapper.documentosEstudianteEntityToDocumentosEstudianteDto(DESaved);
    }

    @Override
    public DocumentosEstudianteDto updateDocumentosEstudianteById(Long id, DocumentosEstudianteDto documentosEstudiante) {
        Optional<DocumentosEstudiante> DEConsulted = documentosEstudianteRepository.findById(id);

        if (DEConsulted.isEmpty()) throw new NotFoundException("El documento con ID " + id + " no ha sido encontrado");

        DocumentosEstudiante de = DEConsulted.get();

        if (documentosEstudiante.nombreDocumento() != null) de.setNombreDocumento(documentosEstudiante.nombreDocumento());
        if (documentosEstudiante.tipoDocumento() != null) de.setTipoDocumento(documentosEstudiante.tipoDocumento());
        if (documentosEstudiante.fechaYHoraDeCarga() != null) de.setFechaYHoraDeCarga(documentosEstudiante.fechaYHoraDeCarga());
        if (documentosEstudiante.tipoDocumento() != null) de.setTipoDocumento(documentosEstudiante.tipoDocumento());

        DocumentosEstudiante updatedDocument = documentosEstudianteRepository.save(de);
        return documentosEstudianteMapper.documentosEstudianteEntityToDocumentosEstudianteDto(updatedDocument);
    }

    @Override
    public DocumentosEstudianteDto findDocumentosEstudianteById(Long id) {
        Optional<DocumentosEstudiante> documentosEstudiante = documentosEstudianteRepository.findById(id);
        if (documentosEstudiante.isEmpty()) throw new NotFoundException("El documento con ID " + id + " no fue encontrado");
        return documentosEstudianteMapper.documentosEstudianteEntityToDocumentosEstudianteDto(documentosEstudiante.get());
    }

    @Override
    public List<DocumentosEstudianteDto> findAllDocumentosEstudiante() {

        List<DocumentosEstudiante> documentos = documentosEstudianteRepository.findAll();

        if (documentos.isEmpty()) throw new NotFoundException("Ningun documento fue encontrado");

        List<DocumentosEstudianteDto> allDocuments = new ArrayList<>();

        documentos.forEach( documentosEstudiante -> {
            DocumentosEstudianteDto de = documentosEstudianteMapper.documentosEstudianteEntityToDocumentosEstudianteDto(documentosEstudiante);
            allDocuments.add(de);
        } );

        return allDocuments;
    }

    @Override
    public void deleteDocumentosEstudianteById(Long id) {
        Optional<DocumentosEstudiante> documentosEstudiante = documentosEstudianteRepository.findById(id);
        if (documentosEstudiante.isEmpty()) throw new NotFoundException("El documento con ID " + id + " no fue encontrado");
        documentosEstudianteRepository.deleteById(id);
    }

    @Override
    public DocumentosEstudianteDto findDocumentosEstudianteByNombreDocumento(String nombreDocumento) {
        Optional<DocumentosEstudiante> documentosEstudiante = documentosEstudianteRepository.findDocumentosEstudianteByNombreDocumento(nombreDocumento);
        if (documentosEstudiante.isEmpty()) throw new NotFoundException("El documento " + nombreDocumento + " no fue encontrado");
        return documentosEstudianteMapper.documentosEstudianteEntityToDocumentosEstudianteDto(documentosEstudiante.get());
    }

    @Override
    public DocumentosEstudianteDto findDocumentosEstudianteByEstudiante(Estudiante estudiante) {
        Optional<DocumentosEstudiante> documentosEstudiante = documentosEstudianteRepository.findDocumentosEstudianteByEstudiante(estudiante);
        if (documentosEstudiante.isEmpty()) throw new NotFoundException("El documento del estudiante " + estudiante.getPrimerNombre() + " no fue encontrado");
        return documentosEstudianteMapper.documentosEstudianteEntityToDocumentosEstudianteDto(documentosEstudiante.get());
    }

    @Override
    public List<DocumentosEstudianteDto> findDocumentosEstudianteByTipoDocumento(String tipoDocumentos) {
        List<DocumentosEstudiante> documentosEstudianteList = documentosEstudianteRepository.findDocumentosEstudianteByTipoDocumento(tipoDocumentos);

        if (documentosEstudianteList.isEmpty()) throw new NotFoundException("Ningun documento fue encontrado");

        List<DocumentosEstudianteDto> allDocuments = new ArrayList<>();

        documentosEstudianteList.forEach( documentosEstudiante -> {
            DocumentosEstudianteDto de = documentosEstudianteMapper.documentosEstudianteEntityToDocumentosEstudianteDto(documentosEstudiante);
            allDocuments.add(de);
        } );

        return allDocuments;
    }

    @Override
    public List<DocumentosEstudianteDto> findDocumentosEstudianteByEstadoDocumento(EstadoDocumento estadoDocumento) {
        List<DocumentosEstudiante> documentosEstudiante = documentosEstudianteRepository.findDocumentosEstudianteByEstadoDocumento(estadoDocumento);

        if (documentosEstudiante.isEmpty()) throw new NotFoundException("no se ha encontrado ningun documento");

        List<DocumentosEstudianteDto> documents = new ArrayList<>();

        documentosEstudiante.forEach( documentosEstudiante1 ->  {
            DocumentosEstudianteDto de = documentosEstudianteMapper.documentosEstudianteEntityToDocumentosEstudianteDto(documentosEstudiante1);
            documents.add(de);
        });

        return documents;
    }
}
