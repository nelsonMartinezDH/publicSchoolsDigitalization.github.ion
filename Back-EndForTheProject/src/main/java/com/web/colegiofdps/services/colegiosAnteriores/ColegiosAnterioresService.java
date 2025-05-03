package com.web.colegiofdps.services.colegiosAnteriores;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.ColegiosAnteriores.ColegiosAnterioresDto;
import com.web.colegiofdps.dtos.ColegiosAnteriores.ColegiosAnterioresToSaveDto;

import java.util.List;

public interface ColegiosAnterioresService {
    ColegiosAnterioresDto saveColegiosAnteriores(ColegiosAnterioresDto colegiosAnteriores);
    ColegiosAnterioresDto updateColegiosAnteriores(Long id, ColegiosAnterioresDto colegiosAnteriores);
    ColegiosAnterioresDto findColegiosAnterioresByid(Long id);
    List<ColegiosAnterioresDto> findAllcolegiosAnteriores();
    void deleteColegiosAnteriores(Long id);
    List<ColegiosAnterioresDto> findColegiosAnterioresByEstudiante(Estudiante estudiante);
    List<ColegiosAnterioresDto> findColegiosAnterioresByNombre(String nombreColegio);
}
