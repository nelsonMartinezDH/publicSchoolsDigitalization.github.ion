package com.web.colegiofdps.services.historialAcademico;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.HistorialAcademico.HistorialAcademicoDto;
import com.web.colegiofdps.dtos.HistorialAcademico.HistorialAcademicoToSaveDto;

import java.time.Year;
import java.util.List;

public interface HistorialAcademicoService {
    HistorialAcademicoDto saveHistorialAcademico(HistorialAcademicoDto historialAcademico);
    HistorialAcademicoDto updateHistorialAcademicoByid(Long id, HistorialAcademicoDto historialAcademico);
    HistorialAcademicoDto findHistorialAcademicoById(Long id);
    List<HistorialAcademicoDto> findAllHistorialesAcademicos();
    void deleteHistorialAcademicoByid(Long id);
    HistorialAcademicoDto findHistorialAcademicoByEstudiante(Estudiante estudiante);
    List<HistorialAcademicoDto> findHistorialAcademicoByAño(Year añoHistorialAcademico);
}
