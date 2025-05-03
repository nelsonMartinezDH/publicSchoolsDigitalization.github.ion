package com.web.colegiofdps.repositories;

import com.web.colegiofdps.AbstractIntegrationDBTest;
import com.web.colegiofdps.Entities.Acudiente;
import com.web.colegiofdps.Entities.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

public class AcudienteRepositoryTest extends AbstractIntegrationDBTest {

    private AcudienteRepository acudienteRepository;

    @Autowired
    public AcudienteRepositoryTest(AcudienteRepository acudienteRepository){
        this.acudienteRepository = acudienteRepository;
    }

    private Acudiente firstAcudiente;
    private Acudiente secondAcudiente;
    private Estudiante estudiante;
    void initMockAcudientes(){
        firstAcudiente = Acudiente.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .segundoApellido("Hazbum")
                .email("nelsonmartinezdh@gmail.com")
                .ocupacion("Estudiante")
                .build();

        acudienteRepository.save(firstAcudiente);
        acudienteRepository.flush();
    }

    @BeforeEach
    void setUp(){
        acudienteRepository.deleteAll();
    }

    @Test
    public void test_findByEmail(){
        firstAcudiente = Acudiente.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .segundoApellido("Hazbum")
                .email("nelsonmartinezdh@gmail.com")
                .ocupacion("Estudiante")
                .build();

        acudienteRepository.save(firstAcudiente);
        Optional<Acudiente> acudiente = acudienteRepository.findByEmail("nelsonmartinezdh@gmail.com");
        assertThat(acudiente).isPresent();

        Long id_clienteBuscado = acudiente.get().getIdAcudiente();
        assertThat(id_clienteBuscado).isEqualTo(firstAcudiente.getIdAcudiente());
    }

    @Test
    public void test_findAll(){
        firstAcudiente = Acudiente.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .segundoApellido("Hazbum")
                .email("nelsonmartinezdh@gmail.com")
                .ocupacion("Estudiante")
                .build();
        acudienteRepository.save(firstAcudiente);

        secondAcudiente = Acudiente.builder()
                .primerNombre("Alisson")
                .primerApellido("Obregon")
                .segundoApellido("Bonnet")
                .email("alissonob@gmail.com")
                .ocupacion("Estudiante")
                .build();
        acudienteRepository.save(secondAcudiente);

        List<Acudiente> acudientes = acudienteRepository.findAll();
        assertThat(acudientes.size()).isGreaterThan(0);
    }

    @Test
    public void test_findAcudientesByEstudiante(){
        firstAcudiente = Acudiente.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .segundoApellido("Hazbum")
                .email("nelsonmartinezdh@gmail.com")
                .ocupacion("Estudiante")
                .build();
        acudienteRepository.save(firstAcudiente);

        Optional<Acudiente> acudiente = acudienteRepository.findById(firstAcudiente.getIdAcudiente());
        assertThat(acudiente).isPresent();
        assertThat(acudiente.get().getEmail()).isEqualTo("nelsonmartinezdh@gmail.com");
    }

    @Test
    public void test_findAcudienteByOcupacionAndEmail(){
        firstAcudiente = Acudiente.builder()
                .primerNombre("Nelson")
                .primerApellido("Martinez")
                .segundoApellido("Hazbum")
                .email("nelsonmartinezdh@gmail.com")
                .ocupacion("Estudiante")
                .build();
        acudienteRepository.save(firstAcudiente);

        List<Acudiente> acudientes = acudienteRepository.findAcudienteByOcupacionAndEmail("Estudiante", "nelsonmartinezdh@gmail.com");
        assertThat(acudientes.size()).isGreaterThan(0);
        assertThat(acudientes.isEmpty()).isFalse();
    }
}
