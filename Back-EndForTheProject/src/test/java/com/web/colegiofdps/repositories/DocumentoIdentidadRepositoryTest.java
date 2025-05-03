package com.web.colegiofdps.repositories;

import com.web.colegiofdps.AbstractIntegrationDBTest;
import com.web.colegiofdps.Entities.DocumentoIdentidad;
import com.web.colegiofdps.Entities.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class DocumentoIdentidadRepositoryTest extends AbstractIntegrationDBTest {

    private DocumentoIdentidadRepository documentoIdentidadRepository;
    private EstudianteRepository estudianteRepository;

    @Autowired
    public DocumentoIdentidadRepositoryTest(DocumentoIdentidadRepository documentoIdentidadRepository,
                                            EstudianteRepository estudianteRepository){
        this.documentoIdentidadRepository = documentoIdentidadRepository;
        this.estudianteRepository = estudianteRepository;
    }

    private DocumentoIdentidad firstdocumentoIdentidad;
    private DocumentoIdentidad secondDocumentoIdentidad;
    private Estudiante estudiante;

    @BeforeEach
    void SetUp(){ documentoIdentidadRepository.deleteAll(); }

    @Test
    public void test_findByEstudiante(){
        LocalDate currentDate = LocalDate.now();
        firstdocumentoIdentidad = DocumentoIdentidad.builder()
                .departamentoDeExpedicion("Magdalena")
                .municipioDeExpedicion("Tenerife")
                .numeroDocumento(1004278279)
                .build();
        documentoIdentidadRepository.save(firstdocumentoIdentidad);

        estudiante = Estudiante.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .documentoIdentidad(firstdocumentoIdentidad)
                .build();
        estudianteRepository.save(estudiante);

        Optional<DocumentoIdentidad> documentoIdentidad = documentoIdentidadRepository.findByEstudiante(estudiante);
        assertThat(documentoIdentidad).isPresent();

    }

    @Test
    public void test_findAll(){
        LocalDate currentDate = LocalDate.now();
        firstdocumentoIdentidad = DocumentoIdentidad.builder()
                .departamentoDeExpedicion("Magdalena")
                .municipioDeExpedicion("Plato")
                .numeroDocumento(1004278279)
                .build();
        documentoIdentidadRepository.save(firstdocumentoIdentidad);

        secondDocumentoIdentidad = DocumentoIdentidad.builder()
                .departamentoDeExpedicion("Magdalena")
                .municipioDeExpedicion("Tenerife")
                .numeroDocumento(26926876)
                .build();
        documentoIdentidadRepository.save(secondDocumentoIdentidad);

        List<DocumentoIdentidad> documentosIdentidad = documentoIdentidadRepository.findAll();
        assertThat(documentosIdentidad.isEmpty()).isFalse();
        assertThat(documentosIdentidad.size()).isGreaterThan(0);
    }

    @Test
    public void test_findByDepartamentoDeExpedicion(){
        LocalDate currentDate = LocalDate.now();
        firstdocumentoIdentidad = DocumentoIdentidad.builder()
                .departamentoDeExpedicion("Magdalena")
                .municipioDeExpedicion("Plato")
                .numeroDocumento(1004278279)
                .build();
        documentoIdentidadRepository.save(firstdocumentoIdentidad);

        List<DocumentoIdentidad> documentosIdentidad = documentoIdentidadRepository.findByDepartamentoDeExpedicion("Magdalena");
        assertThat(documentosIdentidad.size()).isGreaterThan(0);
        assertThat(documentosIdentidad).contains(firstdocumentoIdentidad);
    }
}
