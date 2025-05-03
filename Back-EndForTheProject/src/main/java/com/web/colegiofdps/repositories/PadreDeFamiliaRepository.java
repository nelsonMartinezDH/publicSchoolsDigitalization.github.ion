package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.PadreDeFamilia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PadreDeFamiliaRepository extends JpaRepository<PadreDeFamilia, Long> {

    @Override
    Optional<PadreDeFamilia> findById(Long aLong);

    Optional<PadreDeFamilia> findPadreDeFamiliaByEmail(String email);

    @Override
    List<PadreDeFamilia> findAll();

    List<PadreDeFamilia> findPadresDeFamiliaByEstudiantes(Estudiante estudiante);

    List<PadreDeFamilia> findPadreDeFamiliasByPrimerNombreAndPrimerApellido(String primerNombre, String primeroApellido);
}
