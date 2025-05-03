package com.web.colegiofdps.services.historialMedico;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.HistorialMedico;
import com.web.colegiofdps.dtos.HistorialMedico.HistorialMedicoDto;
import com.web.colegiofdps.dtos.HistorialMedico.HistorialMedicoToSaveDto;

import java.util.List;

public interface HistorialMedicoService {
    HistorialMedicoDto saveHistorialMedico(HistorialMedicoDto historialMedico);
    HistorialMedicoDto updateHistorialMedicoByid(Long id, HistorialMedicoDto historialMedico);
    HistorialMedicoDto findHistorialMedicoByid(Long id);
    List<HistorialMedicoDto> findAllHistorialesMedicos();
    void deleteHistorialMedicoByid(Long id);
    HistorialMedicoDto findHistorialMedicoByEstudiante(Estudiante estudiante);
    List<HistorialMedicoDto> findHistorialMedicoByEPS(String eps);
}
