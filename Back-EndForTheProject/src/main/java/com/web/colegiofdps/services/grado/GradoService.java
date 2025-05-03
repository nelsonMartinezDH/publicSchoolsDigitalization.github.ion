package com.web.colegiofdps.services.grado;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.Grado.GradoDto;
import com.web.colegiofdps.dtos.Grado.GradoToSaveDto;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface GradoService {
    GradoDto saveGrado(GradoDto grado);
    GradoDto updateGradoByid(Long id, GradoDto grado);
    GradoDto findGradoById(Long id);
    List<GradoDto> findAllGrados();
    void deleteGradoById(Long id);
    GradoDto findGradoByEstudiante(Estudiante estudiante);
    GradoDto findGradosByName(String nombreGrado);

}
