package com.web.colegiofdps.services.documentoIdentidad;

import com.web.colegiofdps.Entities.DocumentoIdentidad;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.PadreDeFamilia;
import com.web.colegiofdps.dtos.DocumentoIdentidad.DocumentoIdentidadDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.DocumentoIdentidadMapper;
import com.web.colegiofdps.repositories.DocumentoIdentidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoIdentidadServiceImpl implements DocumentoIdentidadService{

    private final DocumentoIdentidadRepository documentoIdentidadRepository;

    private final DocumentoIdentidadMapper documentoIdentidadMapper;

    @Autowired
    public DocumentoIdentidadServiceImpl(DocumentoIdentidadRepository documentoIdentidadRepository,
                                         DocumentoIdentidadMapper documentoIdentidadMapper) {
        this.documentoIdentidadRepository = documentoIdentidadRepository;
        this.documentoIdentidadMapper = documentoIdentidadMapper;
    }

    @Override
    public DocumentoIdentidadDto saveDocumentoIdentidad(DocumentoIdentidadDto documentoIdentidad) {
        DocumentoIdentidad DIToSave = documentoIdentidadMapper.documentoIdentidadToDocumentoIdentidadEntity(documentoIdentidad);
        DocumentoIdentidad DISaved = documentoIdentidadRepository.save(DIToSave);
        return documentoIdentidadMapper.documentoIdentidadEntityToDocumentoIdentidadDto(DISaved);
    }

    @Override
    public DocumentoIdentidadDto updateDocumentoIdentidadByid(Long id, DocumentoIdentidadDto documentoIdentidad) {
        Optional<DocumentoIdentidad> DIConsulted = documentoIdentidadRepository.findById(id);

        if (DIConsulted.isEmpty()) throw new NotFoundException("Documento identidad con ID " + id + " no ha sido encontrado");

        DocumentoIdentidad di = DIConsulted.get();

        if (documentoIdentidad.numeroDocumento() != null) di.setNumeroDocumento(documentoIdentidad.numeroDocumento());
        if (documentoIdentidad.departamentoDeExpedicion() != null) di.setDepartamentoDeExpedicion(documentoIdentidad.departamentoDeExpedicion());
        if (documentoIdentidad.municipioDeExpedicion() != null) di.setMunicipioDeExpedicion(documentoIdentidad.municipioDeExpedicion());
        if (documentoIdentidad.fechaExpedicion() != null) di.setFechaExpedicion(documentoIdentidad.fechaExpedicion());
        if (documentoIdentidad.fechaExpiracion() != null) di.setFechaExpiracion(documentoIdentidad.fechaExpiracion());

        DocumentoIdentidad updatedDI = documentoIdentidadRepository.save(di);
        return documentoIdentidadMapper.documentoIdentidadEntityToDocumentoIdentidadDto(updatedDI);
    }

    @Override
    public DocumentoIdentidadDto findDocumentoIdentidadById(Long id) {
        Optional<DocumentoIdentidad> documentoIdentidad = documentoIdentidadRepository.findById(id);
        if (documentoIdentidad.isEmpty()) throw new NotFoundException("Documento de identidad con ID " + id + " no encontrado");
        return documentoIdentidadMapper.documentoIdentidadEntityToDocumentoIdentidadDto(documentoIdentidad.get());
    }

    @Override
    public List<DocumentoIdentidadDto> findAllDocumentoIdentidad() {

        List<DocumentoIdentidad> documentosDeIdentidad = documentoIdentidadRepository.findAll();

        if (documentosDeIdentidad.isEmpty()) throw new NotFoundException("Ningun documento de identidad ha sido encontrado");

        List<DocumentoIdentidadDto> allDIs = new ArrayList<>();

        documentosDeIdentidad.forEach( documentoIdentidad -> {
            DocumentoIdentidadDto di = documentoIdentidadMapper.documentoIdentidadEntityToDocumentoIdentidadDto(documentoIdentidad);
            allDIs.add(di);
        } );

        return allDIs;
    }

    @Override
    public void deleteDocumentoIdentidadById(Long id) {
        Optional<DocumentoIdentidad> documentoIdentidad = documentoIdentidadRepository.findById(id);
        if (documentoIdentidad.isEmpty()) throw new NotFoundException("Documento de identidad con ID " + id + " no ha sido encontrado");
        documentoIdentidadRepository.deleteById(id);
    }

    @Override
    public DocumentoIdentidadDto findDocumentoIdentidadByNumeroDocumento(Integer numeroDocumento) {
        Optional<DocumentoIdentidad> documentoIdentidad = documentoIdentidadRepository.findByNumeroDocumento(numeroDocumento);
        if (documentoIdentidad.isEmpty()) throw new NotFoundException("Documento de identidad con numero de documento " + numeroDocumento + " no ha sido encontrado");
        return documentoIdentidadMapper.documentoIdentidadEntityToDocumentoIdentidadDto(documentoIdentidad.get());
    }

    @Override
    public List<DocumentoIdentidadDto> findDocumentoIdentidadByFechaDeExpedicion(Date fechaExpedicion) {
        List<DocumentoIdentidad> DIsMatched = documentoIdentidadRepository.findByFechaExpedicion(fechaExpedicion);

        if (DIsMatched.isEmpty()) throw new NotFoundException("Ningun documento de identidad ha sido encontrado");

        List<DocumentoIdentidadDto> DIsToReturn = new ArrayList<>();

        DIsMatched.forEach( documentoIdentidad -> {
            DocumentoIdentidadDto mappedDI = documentoIdentidadMapper.documentoIdentidadEntityToDocumentoIdentidadDto(documentoIdentidad);
            DIsToReturn.add(mappedDI);
        } );

        return DIsToReturn;
    }

    @Override
    public DocumentoIdentidadDto findDocumentoIdentidadByEstudiante(Estudiante estudiante) {
        Optional<DocumentoIdentidad> documentoIdentidad = documentoIdentidadRepository.findByEstudiante(estudiante);
        if (documentoIdentidad.isEmpty()) throw new NotFoundException("El documento del estudiante " + estudiante.getPrimerNombre() + " no ha sido encontrado");
        return documentoIdentidadMapper.documentoIdentidadEntityToDocumentoIdentidadDto(documentoIdentidad.get());
    }
}
