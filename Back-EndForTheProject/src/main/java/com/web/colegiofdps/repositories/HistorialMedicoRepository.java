package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.HistorialMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Long> {

    @Override
    Optional<HistorialMedico> findById(Long aLong);

    List<HistorialMedico> findHistorialMedicoByEPS(String eps);

    Optional<HistorialMedico> findHistorialMedicosByEstudiante(Estudiante estudiante);

    @Override
    List<HistorialMedico> findAll();
}
