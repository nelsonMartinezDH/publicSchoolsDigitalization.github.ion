package com.web.colegiofdps.repositories;

import com.web.colegiofdps.AbstractIntegrationDBTest;
import com.web.colegiofdps.Entities.ColegiosAnteriores;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ColegiosAnterioresRepositoryTest extends AbstractIntegrationDBTest {

    private ColegiosAnterioresRepository colegiosAnterioresRepository;

    @Autowired
    public ColegiosAnterioresRepositoryTest(ColegiosAnterioresRepository colegiosAnterioresRepository){
        this.colegiosAnterioresRepository = colegiosAnterioresRepository;
    }

    private ColegiosAnteriores firstColegioAnterior;

    @BeforeEach
    void setUp(){ colegiosAnterioresRepository.deleteAll(); }

    @Test
    public void test_findById(){
        firstColegioAnterior = ColegiosAnteriores.builder()
                .nombreColegio("Anuar Rivera Jattar")
                .build();
        colegiosAnterioresRepository.save(firstColegioAnterior);

        Optional<ColegiosAnteriores> colegiosAnteriores = colegiosAnterioresRepository.findById(firstColegioAnterior.getIdColegioAnterior());
        assertThat(colegiosAnteriores).isPresent();
    }

    @Test
    public void test_findByNombreColegio(){
        firstColegioAnterior = ColegiosAnteriores.builder()
                .nombreColegio("Anuar Rivera Jattar")
                .build();
        colegiosAnterioresRepository.save(firstColegioAnterior);

        List<ColegiosAnteriores> colegiosAnteriores = colegiosAnterioresRepository.findByNombreColegio("Anuar Rivera Jattar");
        assertThat(colegiosAnteriores.getFirst()).isEqualTo(firstColegioAnterior);
        assertThat(colegiosAnteriores.get(0)).isEqualTo("Anuar Rivera Jattar");
    }
}
