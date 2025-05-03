package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.Acudiente;
import com.web.colegiofdps.Entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcudienteRepository extends JpaRepository<Acudiente, Long> {

    @Override
    Optional<Acudiente> findById(Long aLong);


    @Override
    List<Acudiente> findAll();

    @Override
    List<Acudiente> findAllById(Iterable<Long> longs);

    List<Acudiente> findAcudientesByEstudiantes(Estudiante estudiante);

    Optional<Acudiente> findByEmail(String email);

    List<Acudiente> findAcudienteByOcupacionAndEmail(String ocupacion, String email);

    List<Acudiente> findAcudientesByOcupacion(String ocupacion);

    List<Acudiente> findAcudientesByPrimerNombre(String primerNombre);
}
