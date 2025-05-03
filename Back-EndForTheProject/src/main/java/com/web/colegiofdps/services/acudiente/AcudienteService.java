package com.web.colegiofdps.services.acudiente;

import com.web.colegiofdps.dtos.Acudiente.AcudienteDto;
import com.web.colegiofdps.dtos.Acudiente.AcudienteToSaveDto;

import java.util.List;

public interface AcudienteService {
    AcudienteDto saveAcudiente(AcudienteDto acudiente);
    AcudienteDto updateAcudientebyId(Long id, AcudienteDto Acudiente);
    AcudienteDto findAcudientebyId(Long id);
    List<AcudienteDto> findAllAcudientes();
    void deleteAcudientebyId(Long id);
    AcudienteDto findAcudientebyEmail(String email);
    List<AcudienteDto> findAcudienteByOcupacion(String ocupacion);
    List<AcudienteDto> findAcudientebyNombre(String nombre);
}
