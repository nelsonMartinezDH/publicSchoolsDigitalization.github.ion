package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.CitaPsicologica;
import com.web.colegiofdps.Entities.EstadoCitaPsicologica;
import com.web.colegiofdps.Entities.Estudiante;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitaPsicologicaRepository extends JpaRepository<CitaPsicologica, Long> {

    @Override
    Optional<CitaPsicologica> findById(Long aLong);

    @Override
    List<CitaPsicologica> findAll();

    @Override
    <S extends CitaPsicologica> List<S> findAll(Example<S> example, Sort sort);

    List<CitaPsicologica> findCitaPsicologicasByEstudiantes(Estudiante estudiante);

    List<CitaPsicologica> findCitaPsicologicaByEstadoCitaPsicologica(EstadoCitaPsicologica estadoCitaPsicologica);

    List<CitaPsicologica> findCitaPsicologicasByFechaYHoraDeCita(LocalDateTime fechaHoraDeCita);
}
