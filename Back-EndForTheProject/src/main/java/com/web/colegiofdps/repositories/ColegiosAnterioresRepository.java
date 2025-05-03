package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.ColegiosAnteriores;
import com.web.colegiofdps.Entities.Estudiante;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColegiosAnterioresRepository extends JpaRepository<ColegiosAnteriores, Long> {

    @Override
    Optional<ColegiosAnteriores> findById(Long aLong);

    @Override
    <S extends ColegiosAnteriores> List<S> findAll(Example<S> example, Sort sort);

    @Override
    List<ColegiosAnteriores> findAllById(Iterable<Long> longs);

    List<ColegiosAnteriores> findByNombreColegio(String nombreColegio);

    List<ColegiosAnteriores> findByEstudiante(Estudiante estudiante);
}
