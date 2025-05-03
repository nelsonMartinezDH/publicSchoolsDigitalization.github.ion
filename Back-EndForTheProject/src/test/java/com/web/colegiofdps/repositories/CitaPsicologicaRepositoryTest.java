package com.web.colegiofdps.repositories;


import com.web.colegiofdps.AbstractIntegrationDBTest;
import com.web.colegiofdps.Entities.CitaPsicologica;
import com.web.colegiofdps.Entities.EstadoCitaPsicologica;
import com.web.colegiofdps.Entities.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CitaPsicologicaRepositoryTest extends AbstractIntegrationDBTest {

    private CitaPsicologicaRepository citaPsicologicaRepository;
    private EstudianteRepository estudianteRepository;

    @Autowired
    public CitaPsicologicaRepositoryTest(CitaPsicologicaRepository citaPsicologicaRepository, EstudianteRepository estudianteRepository){
        this.citaPsicologicaRepository = citaPsicologicaRepository;
        this.estudianteRepository = estudianteRepository;
    }

    private CitaPsicologica firstCitaPsicologica;
    private CitaPsicologica secondCitaPsicologica;
    private Estudiante estudiante;

    @BeforeEach
    void setUp(){ citaPsicologicaRepository.deleteAll(); }

    @Test
    public void test_findById(){
        firstCitaPsicologica = CitaPsicologica.builder()
                .estadoCitaPsicologica(EstadoCitaPsicologica.PENDIENTE)
                .motivoCita("Sansion disciplinaria")
                .fechaYHoraDeCita(LocalDateTime.now())
                .build();
        citaPsicologicaRepository.save(firstCitaPsicologica);

        Optional<CitaPsicologica> citaPsicologica = citaPsicologicaRepository.findById(firstCitaPsicologica.getIdCitaPsicologica());
        assertThat(citaPsicologica).isPresent();
    }

    @Test
    public void test_findAll(){
        firstCitaPsicologica = CitaPsicologica.builder()
                .estadoCitaPsicologica(EstadoCitaPsicologica.PENDIENTE)
                .motivoCita("Sansion disciplinaria")
                .fechaYHoraDeCita(LocalDateTime.now())
                .build();
        citaPsicologicaRepository.save(firstCitaPsicologica);

        secondCitaPsicologica = CitaPsicologica.builder()
                .estadoCitaPsicologica(EstadoCitaPsicologica.PENDIENTE)
                .motivoCita("Comportamiento")
                .fechaYHoraDeCita(LocalDateTime.now())
                .build();
        citaPsicologicaRepository.save(secondCitaPsicologica);

        List<CitaPsicologica> citasPsicologicas = citaPsicologicaRepository.findAll();
        assertThat(citasPsicologicas.size()).isEqualTo(2);
        assertThat(citasPsicologicas.isEmpty()).isFalse();
    }

    @Test
    public void test_findCitaPsicologicaByEstudiante(){
        estudiante = Estudiante.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .email("nelsonmartinezdh@gmail.com")
                .build();
        estudianteRepository.save(estudiante);
        List<Estudiante> estudiantes = estudianteRepository.findAll();

        firstCitaPsicologica = CitaPsicologica.builder()
                .estadoCitaPsicologica(EstadoCitaPsicologica.PENDIENTE)
                .motivoCita("Sansion disciplinaria")
                .fechaYHoraDeCita(LocalDateTime.now())
                .estudiantes(estudiantes)
                .build();
        citaPsicologicaRepository.save(firstCitaPsicologica);

        List<CitaPsicologica> citasPsicologicas = citaPsicologicaRepository.findCitaPsicologicasByEstudiantes(estudiante);
        assertThat(citasPsicologicas.isEmpty()).isFalse();
        assertThat(citasPsicologicas).contains(firstCitaPsicologica);
    }

    @Test
    public void test_findCitaPsicologicaByEstadoCitaPsicologica(){
        firstCitaPsicologica = CitaPsicologica.builder()
                .estadoCitaPsicologica(EstadoCitaPsicologica.PENDIENTE)
                .motivoCita("Sansion disciplinaria")
                .fechaYHoraDeCita(LocalDateTime.now())
                .build();
        citaPsicologicaRepository.save(firstCitaPsicologica);

        List<CitaPsicologica> citasPsicologicas = citaPsicologicaRepository.findCitaPsicologicaByEstadoCitaPsicologica(EstadoCitaPsicologica.PENDIENTE);
        assertThat(citasPsicologicas.size()).isGreaterThan(0);
        assertThat(citasPsicologicas.isEmpty()).isFalse();
    }
}
