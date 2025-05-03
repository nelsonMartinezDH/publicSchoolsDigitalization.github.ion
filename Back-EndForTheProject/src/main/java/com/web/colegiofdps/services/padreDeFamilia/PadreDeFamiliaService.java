package com.web.colegiofdps.services.padreDeFamilia;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.PadreDeFamilia;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaDto;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaToSaveDto;

import java.util.List;

public interface PadreDeFamiliaService {
    PadreDeFamiliaDto savePadreDeFamilia(PadreDeFamiliaDto padreDeFamilia);
    PadreDeFamiliaDto updatePadreDeFamiliaByid(Long id, PadreDeFamiliaDto padreDeFamilia);
    PadreDeFamiliaDto findPadreDeFamiliaByid(Long id);
    List<PadreDeFamiliaDto> findAllPadresDeFamilia();
    void deletePadreDeFamiliaByid(Long id);
    PadreDeFamiliaDto findPadreDeFamiliaByemail(String email);
    List<PadreDeFamiliaDto> findPadreDeFamiliaByEstudiante(Estudiante estudiante);
    List<PadreDeFamiliaDto> findPadreDeFamuliaByPrimerNombreAndPrimerApellido(String primerNombre, String primerApellido);
}
