package com.web.colegiofdps.services.estudiante;

import com.web.colegiofdps.Entities.DocumentoIdentidad;
import com.web.colegiofdps.Entities.Matricula;
import com.web.colegiofdps.dtos.Estudiante.EstudianteDto;
import com.web.colegiofdps.dtos.Estudiante.EstudianteToSaveDto;

import java.util.List;

public interface EstudianteService {
    EstudianteDto saveEstudiante(EstudianteDto estudiante);
    EstudianteDto updateEstudianteById(Long id, EstudianteDto estudiante);
    EstudianteDto findEstudianteById(Long id);
    List<EstudianteDto> findAllEstudiantes();
    void deleteEstudianteById(Long id);
    List<EstudianteDto> findEstudianteByPrimerNombreAndPrimerApellido(String primerNombre, String primerApellido);
    EstudianteDto findEstudianteByMatricula(Matricula matricula);
    EstudianteDto findEstudianteByDocumentoIdentidad(DocumentoIdentidad documentoIdentidad);
}
