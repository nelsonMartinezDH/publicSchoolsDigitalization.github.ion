package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.EstadoMatricula;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @Override
    Optional<Matricula> findById(Long aLong);

    Optional<Matricula> findMatriculaByEstudiante(Estudiante estudiante);

    @Override
    List<Matricula> findAll();

    List<Matricula> findMatriculasByFechaMatricula(Date fechaMatricula);

    List<Matricula> findMatriculasByEstadoMatricula(EstadoMatricula estadoMatricula);

    Optional<EstadoMatricula> findEstadoMatriculaByidMatricula(Long idMatricula);
}
