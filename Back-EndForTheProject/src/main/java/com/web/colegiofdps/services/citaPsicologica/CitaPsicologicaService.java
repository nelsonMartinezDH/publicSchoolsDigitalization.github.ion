package com.web.colegiofdps.services.citaPsicologica;

import com.web.colegiofdps.Entities.EstadoCitaPsicologica;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.CitaPsicologica.CitaPsicologicaDto;
import com.web.colegiofdps.dtos.CitaPsicologica.CitaPsicologicaToSaveDto;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaPsicologicaService {
    CitaPsicologicaDto saveCitaPsicologica(CitaPsicologicaDto citaPsicologica);
    CitaPsicologicaDto updateCitaPsicologicaById(Long id, CitaPsicologicaDto citaPsicologica);
    CitaPsicologicaDto findCitaPsicologicaById(Long id);
    List<CitaPsicologicaDto> findAllCitasPsicologicas();
    void deleteCitaPsicologicaById(Long id);
    List<CitaPsicologicaDto> findCitaPsicologicaByEstadoCita(EstadoCitaPsicologica estadoCitaPsicologica);
    List<CitaPsicologicaDto> findCitaPsicologicaByEstudiante(Estudiante estudiante);
    List<CitaPsicologicaDto> findCitaPsicologicaByFechaYHora(LocalDateTime fechaYHora);
}
