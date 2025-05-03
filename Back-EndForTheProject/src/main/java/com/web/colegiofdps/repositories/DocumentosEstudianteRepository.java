package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.DocumentosEstudiante;
import com.web.colegiofdps.Entities.EstadoDocumento;
import com.web.colegiofdps.Entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentosEstudianteRepository extends JpaRepository<DocumentosEstudiante, Long> {

    @Override
    List<DocumentosEstudiante> findAll();

    List<DocumentosEstudiante> findByEstudianteAndEstadoDocumento(Estudiante estudiante, EstadoDocumento estadoDocumento);

    List<DocumentosEstudiante> findDocumentosEstudianteByTipoDocumento(String tipoDeDocumento);

    Optional<DocumentosEstudiante> findDocumentosEstudianteByNombreDocumento(String nombreDocumento);

    Optional<DocumentosEstudiante> findDocumentosEstudianteByEstudiante(Estudiante estudiante);

    List<DocumentosEstudiante> findDocumentosEstudianteByEstadoDocumento(EstadoDocumento estadoDocumento);
}
