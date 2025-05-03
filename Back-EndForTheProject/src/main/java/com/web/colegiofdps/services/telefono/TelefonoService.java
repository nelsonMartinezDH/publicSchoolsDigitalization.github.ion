package com.web.colegiofdps.services.telefono;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.PadreDeFamilia;
import com.web.colegiofdps.Entities.Telefono;
import com.web.colegiofdps.Entities.TipoTelefono;
import com.web.colegiofdps.dtos.Telefono.TelefonoDto;
import com.web.colegiofdps.dtos.Telefono.TelefonoToSaveDto;

import java.util.List;

public interface TelefonoService {
    TelefonoDto saveTelefono(TelefonoDto telefono);
    TelefonoDto updateTelefonoByid(Long id, TelefonoDto telefono);
    TelefonoDto findTelefonoByid(Long id);
    List<TelefonoDto> findAllTelefonos();
    TelefonoDto findTelefonoByNumeroTelefonico(String numeroTelefonico);
    void deleteTelefonoByid(Long id);
    List<TelefonoDto> findTelefonoByTipoTelefono(TipoTelefono tipoTelefono);
    TelefonoDto findTelefonoByPadreDeFamilia(PadreDeFamilia padreDeFamilia);
}
