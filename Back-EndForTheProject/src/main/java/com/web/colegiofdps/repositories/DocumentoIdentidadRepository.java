package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.DocumentoIdentidad;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.PadreDeFamilia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentoIdentidadRepository extends JpaRepository<DocumentoIdentidad, Long> {

    Optional<DocumentoIdentidad> findByEstudiante(Estudiante estudiante);

    @Override
    List<DocumentoIdentidad> findAll();

    List<DocumentoIdentidad> findByDepartamentoDeExpedicion(String departamentoDeExpedicion);

    List<DocumentoIdentidad> findByFechaExpedicionAndFechaExpiracion(Date fechaExpedicion, Date fechaExpiracion);

    Optional<DocumentoIdentidad> findByNumeroDocumento(Integer numeroDocumento);

    List<DocumentoIdentidad> findByFechaExpedicion(Date fechaExpedicion);
}
