package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.Grado;
import com.web.colegiofdps.Entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Long> {

    Optional<Grado> findGradoByEstudiantes(Estudiante estudiante);

    @Override
    List<Grado> findAll();

    List<Grado> findGradoByFechaDeMatricula(Date fechaDeMatricula);

    Optional<Grado> findGradoByNombre(String nombreGrado);
}
