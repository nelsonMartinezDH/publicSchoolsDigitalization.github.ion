package com.web.colegiofdps.services.matricula;

import com.web.colegiofdps.Entities.EstadoMatricula;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.Matricula;
import com.web.colegiofdps.dtos.Matricula.MatriculaDto;
import com.web.colegiofdps.dtos.Matricula.MatriculaToSaveDto;

import java.util.Date;
import java.util.List;

public interface MatriculaService {
    MatriculaDto saveMatricula(MatriculaDto matricula);
    MatriculaDto updateMatriculaByid(Long id, MatriculaDto matricula);
    MatriculaDto findMatriculaById(Long id);
    List<MatriculaDto> findAllMatriculas();
    void deleteMatriculaById(Long id);
    MatriculaDto findMatriculaByEstudiante(Estudiante estudiante);
    List<MatriculaDto> findMatriculaByEstadoMatricula(EstadoMatricula estadoMatricula);
    EstadoMatricula findEstadoMatriculaByIdMatricula(Long idMatricula);
    List<MatriculaDto> findMatriculaByFechaMatricula(Date fechaMatricula);
    MatriculaDto iniciarProcesoDeMatricula(MatriculaDto matriculaDto);
}
