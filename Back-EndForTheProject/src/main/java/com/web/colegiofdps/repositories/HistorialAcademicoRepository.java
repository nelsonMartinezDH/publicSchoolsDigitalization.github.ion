package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.HistorialAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Repository
public interface HistorialAcademicoRepository extends JpaRepository<HistorialAcademico, Long> {

    @Override
    Optional<HistorialAcademico> findById(Long aLong);

    Optional<HistorialAcademico> findHistorialAcademicoByEstudiante(Estudiante estudiante);

    @Override
    List<HistorialAcademico> findAll();

    List<HistorialAcademico> findHistorialAcademicosByAñoHistorialAcademico(Year year);
}
