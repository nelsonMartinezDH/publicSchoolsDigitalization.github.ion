package com.web.colegiofdps.repositories;

import com.web.colegiofdps.AbstractIntegrationDBTest;
import com.web.colegiofdps.Entities.DocumentosEstudiante;
import com.web.colegiofdps.Entities.EstadoDocumento;
import com.web.colegiofdps.Entities.Estudiante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DocumentosEstudianteRepositoryTest extends AbstractIntegrationDBTest {

    private DocumentosEstudianteRepository documentosEstudianteRepository;
    private EstudianteRepository estudianteRepository;

    @Autowired
    public DocumentosEstudianteRepositoryTest(DocumentosEstudianteRepository documentosEstudianteRepository,
                                              EstudianteRepository estudianteRepository){
        this.documentosEstudianteRepository = documentosEstudianteRepository;
        this.estudianteRepository = estudianteRepository;
    }

    private DocumentosEstudiante firstdocumentoEstudiante;
    private DocumentosEstudiante secondDocumentoEstudiante;
    private Estudiante estudiante;

    public void setUp(){ documentosEstudianteRepository.deleteAll(); }

    @Test
    public void test_findAll(){
        firstdocumentoEstudiante = DocumentosEstudiante.builder()
                .estadoDocumento(EstadoDocumento.APROBADO)
                .nombreDocumento("documento entidad EPS")
                .tipoDocumento("pdf")
                .fechaYHoraDeCarga(LocalDateTime.now())
                .build();
        documentosEstudianteRepository.save(firstdocumentoEstudiante);

        secondDocumentoEstudiante = DocumentosEstudiante.builder()
                .estadoDocumento(EstadoDocumento.PENDIENTE)
                .nombreDocumento("documento notas anteriores")
                .tipoDocumento("word")
                .build();
        documentosEstudianteRepository.save(secondDocumentoEstudiante);

        List<DocumentosEstudiante> documentosEstudiante = documentosEstudianteRepository.findAll();
        assertThat(documentosEstudiante.isEmpty()).isFalse();
        assertThat(documentosEstudiante.size()).isEqualTo(2);
    }

    @Test
    public void test_findByEstudianteAndEstadoDocumento(){
        firstdocumentoEstudiante = DocumentosEstudiante.builder()
                .estadoDocumento(EstadoDocumento.APROBADO)
                .nombreDocumento("documento entidad EPS")
                .tipoDocumento("pdf")
                .fechaYHoraDeCarga(LocalDateTime.now())
                .build();
        documentosEstudianteRepository.save(firstdocumentoEstudiante);
        List<DocumentosEstudiante> documentosEstudianteList = documentosEstudianteRepository.findAll();

        estudiante = Estudiante.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .documentosEstudiante(documentosEstudianteList)
                .build();
        estudianteRepository.save(estudiante);

        List<DocumentosEstudiante> documentosEstudiante = documentosEstudianteRepository.findByEstudianteAndEstadoDocumento(estudiante, EstadoDocumento.APROBADO);
        assertThat(documentosEstudiante.size()).isNotZero();
        assertThat(documentosEstudiante).contains(firstdocumentoEstudiante);
    }

    @Test
    public void test_findDocumentosEstudianteByTipoDocumento(){
        firstdocumentoEstudiante = DocumentosEstudiante.builder()
                .estadoDocumento(EstadoDocumento.APROBADO)
                .nombreDocumento("documento entidad EPS")
                .tipoDocumento("pdf")
                .fechaYHoraDeCarga(LocalDateTime.now())
                .build();
        documentosEstudianteRepository.save(firstdocumentoEstudiante);

        List<DocumentosEstudiante> documentosEstudiante = documentosEstudianteRepository.findDocumentosEstudianteByTipoDocumento("pdf");
        assertThat(documentosEstudiante.isEmpty()).isFalse();
    }
}
