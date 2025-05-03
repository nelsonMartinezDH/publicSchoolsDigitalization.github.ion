package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByPrimerNombreAndPrimerApellido(String primerNombre, String primerApellido);

    List<Estudiante> findEstudiantesByCiudadNacimiento(String ciudadNacimiento);

    List<Estudiante> findEstudiantesByColegiosAnteriores(ColegiosAnteriores colegiosAnteriores);

    @Override
    List<Estudiante> findAll();

    List<Estudiante> findEstudiantesByAcudientes(Acudiente acudiente);

    Optional<Estudiante> findEstudianteByMatricula(Matricula matricula);

    Optional<Estudiante> findEstudiantesByDocumentoIdentidad(DocumentoIdentidad documentoIdentidad);
}
