package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.TipoTelefono;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.PadreDeFamilia;
import com.web.colegiofdps.Entities.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono, Long> {

    @Override
    Optional<Telefono> findById(Long aLong);

    Optional<Telefono> findTelefonoByNumeroTelefonico(String numeroTelefonico);

    @Override
    List<Telefono> findAll();

    List<Telefono> findTelefonosByEstudiante(Estudiante estudiante);

    List<Telefono> findTelefonosByPadreDeFamilia(PadreDeFamilia padreDeFamilia);

    List<Telefono> findTelefonosByTipoTelefono(TipoTelefono tipoTelefono);
}
