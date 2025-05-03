package com.web.colegiofdps.repositories;

import com.web.colegiofdps.AbstractIntegrationDBTest;
import com.web.colegiofdps.Entities.Acudiente;
import com.web.colegiofdps.Entities.ColegiosAnteriores;
import com.web.colegiofdps.Entities.Estudiante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class EstudianteRepositoryTest extends AbstractIntegrationDBTest {

    private EstudianteRepository estudianteRepository;
    private ColegiosAnterioresRepository colegiosAnterioresRepository;
    private AcudienteRepository acudienteRepository;

    @Autowired
    public EstudianteRepositoryTest(EstudianteRepository estudianteRepository,
                                    ColegiosAnterioresRepository colegiosAnterioresRepository,
                                    AcudienteRepository acudienteRepository) {
        this.estudianteRepository = estudianteRepository;
        this.colegiosAnterioresRepository = colegiosAnterioresRepository;
        this.acudienteRepository = acudienteRepository;
    }

    private Estudiante firstEstudiante;
    private Estudiante secondEstudiante;
    private ColegiosAnteriores colegioAnterior;
    private Acudiente firstAcudiente;
    private Acudiente secondAcudiente;

    public void setUp(){ estudianteRepository.deleteAll(); }

    @Test
    public void test_findByPrimerNombreAndPrimerApellido(){
        firstEstudiante = Estudiante.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .email("nelsonmartinezdh@gmail.com")
                .build();
        estudianteRepository.save(firstEstudiante);

        Optional<Estudiante> estudiantes = estudianteRepository.findByPrimerNombreAndPrimerApellido("Nelson", "Martinez");
        assertThat(estudiantes.isPresent()).isTrue();
        assertThat(estudiantes.get().getPrimerNombre()).isEqualTo("Nelson");
    }

    @Test
    public void test_findEstudiantesByCiudadNacimiento(){
        firstEstudiante = Estudiante.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .email("nelsonmartinezdh@gmail.com")
                .ciudadNacimiento("Santa Marta")
                .build();
        estudianteRepository.save(firstEstudiante);

        List<Estudiante> estudiantes = estudianteRepository.findEstudiantesByCiudadNacimiento("Santa Marta");
        assertThat(estudiantes.size()).isNotZero();
        assertThat(estudiantes.getFirst()).isEqualTo(firstEstudiante);
    }

    @Test
    public void test_findEstudiantesByColegiosAnteriores(){
        firstEstudiante = Estudiante.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .email("nelsonmartinezdh@gmail.com")
                .ciudadNacimiento("Santa Marta")
                .build();
        estudianteRepository.save(firstEstudiante);

        secondEstudiante = Estudiante.builder()
                .primerNombre("Carlos")
                .primerApellido("Linares")
                .email("carlosLinares@gmail.com")
                .ciudadNacimiento("Fundacion")
                .build();
        estudianteRepository.save(secondEstudiante);

        colegioAnterior = ColegiosAnteriores.builder()
                .nombreColegio("Anuar Rivera Jattar")
                .estudiante(firstEstudiante)
                .estudiante(secondEstudiante)
                .build();
        colegiosAnterioresRepository.save(colegioAnterior);

        List<Estudiante> estudiantes = estudianteRepository.findEstudiantesByColegiosAnteriores(colegioAnterior);
        assertThat(estudiantes.contains(firstEstudiante)).isTrue();
        assertThat(estudiantes.size()).isNotZero();
        assertThat(estudiantes.size()).isEqualTo(2);
    }

    @Test
    public void test_findAll(){
        firstEstudiante = Estudiante.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .email("nelsonmartinezdh@gmail.com")
                .ciudadNacimiento("Santa Marta")
                .build();
        estudianteRepository.save(firstEstudiante);

        secondEstudiante = Estudiante.builder()
                .primerNombre("Carlos")
                .primerApellido("Linares")
                .email("carlosLinares@gmail.com")
                .ciudadNacimiento("Fundacion")
                .build();
        estudianteRepository.save(secondEstudiante);

        List<Estudiante> estudiantes = estudianteRepository.findAll();
        assertThat(estudiantes.size()).isEqualTo(2);
        assertThat(estudiantes.getFirst()).isEqualTo(firstEstudiante);
    }

    @Test
    public void test_findEstudiantesByAcudientes() {
        firstAcudiente = Acudiente.builder()
                .primerNombre("Sheylon")
                .primerApellido("Navarro")
                .email("sheylonNavarro@gmail.com")
                .build();
        acudienteRepository.save(firstAcudiente);

        secondAcudiente = Acudiente.builder()
                .primerNombre("Karen")
                .primerApellido("Lozano")
                .email("karenlozano@gmail.com")
                .build();
        acudienteRepository.save(secondAcudiente);
        List<Acudiente> acudientesList = acudienteRepository.findAll();

        firstEstudiante = Estudiante.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .email("nelsonmartinezdh@gmail.com")
                .ciudadNacimiento("Santa Marta")
                .acudientes(acudientesList)
                .build();
        estudianteRepository.save(firstEstudiante);

        secondEstudiante = Estudiante.builder()
                .primerNombre("Carlos")
                .primerApellido("Linares")
                .email("carlosLinares@gmail.com")
                .ciudadNacimiento("Fundacion")
                .acudientes(acudientesList)
                .build();
        estudianteRepository.save(secondEstudiante);

        List<Estudiante> estudiantes = estudianteRepository.findEstudiantesByAcudientes(firstAcudiente);
        assertThat(estudiantes).isNotEmpty();
        assertThat(estudiantes.size()).isEqualTo(2);
        assertThat(estudiantes.contains(firstEstudiante)).isTrue();
    }
}
