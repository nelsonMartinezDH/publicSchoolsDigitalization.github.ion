package com.web.colegiofdps.services.historialMedico;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.HistorialMedico;
import com.web.colegiofdps.dtos.HistorialMedico.HistorialMedicoDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.HistorialMedicoMapper;
import com.web.colegiofdps.repositories.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoServiceImpl implements HistorialMedicoService{

    private final HistorialMedicoRepository historialMedicoRepository;

    private final HistorialMedicoMapper historialMedicoMapper;

    @Autowired
    public HistorialMedicoServiceImpl(HistorialMedicoRepository historialMedicoRepository,
                                      HistorialMedicoMapper historialMedicoMapper) {
        this.historialMedicoRepository = historialMedicoRepository;
        this.historialMedicoMapper = historialMedicoMapper;
    }

    @Override
    public HistorialMedicoDto saveHistorialMedico(HistorialMedicoDto historialMedico) {
        HistorialMedico HMToSave = historialMedicoMapper.historialMedicoDtoToHistorialMedicoEntity(historialMedico);
        HistorialMedico HMSaved = historialMedicoRepository.save(HMToSave);
        return historialMedicoMapper.historialMedicoEntityToHistorialMedicoDto(HMSaved);
    }

    @Override
    public HistorialMedicoDto updateHistorialMedicoByid(Long id, HistorialMedicoDto historialMedico) {
        Optional<HistorialMedico> HMConsulted = historialMedicoRepository.findById(id);

        if (HMConsulted.isEmpty()) throw new NotFoundException("El historial medico con el ID " + id + " no fue encontrado");

        HistorialMedico hm = HMConsulted.get();

        if (historialMedico.EPS() != null) hm.setEPS(historialMedico.EPS());
        if (historialMedico.alergias() != null) hm.setAlergias(historialMedico.alergias());
        if (historialMedico.condicionesMedicas() != null) hm.setCondicionesMedicas(historialMedico.condicionesMedicas());

        HistorialMedico updatedHM = historialMedicoRepository.save(hm);
        return historialMedicoMapper.historialMedicoEntityToHistorialMedicoDto(updatedHM);
    }

    @Override
    public HistorialMedicoDto findHistorialMedicoByid(Long id) {
        Optional<HistorialMedico> foundHM = historialMedicoRepository.findById(id);
        if (foundHM.isEmpty()) throw new NotFoundException("El historial medico con el ID " + id + " no fue encontrado");
        return historialMedicoMapper.historialMedicoEntityToHistorialMedicoDto(foundHM.get());
    }

    @Override
    public List<HistorialMedicoDto> findAllHistorialesMedicos() {
        List<HistorialMedico> historialMedicoList = historialMedicoRepository.findAll();

        if (historialMedicoList.isEmpty()) throw new NotFoundException("Ningun historial medico fue encontrado");

        List<HistorialMedicoDto> allHM = new ArrayList<>();

        historialMedicoList.forEach( historialMedico -> {
            HistorialMedicoDto h = historialMedicoMapper.historialMedicoEntityToHistorialMedicoDto(historialMedico);
            allHM.add(h);
        } );

        return allHM;
    }

    @Override
    public void deleteHistorialMedicoByid(Long id) {
        Optional<HistorialMedico> HMToDelete = historialMedicoRepository.findById(id);
        if (HMToDelete.isEmpty()) throw new NotFoundException("El historial medico con ID " + id + " no fue encontrado");
        historialMedicoRepository.deleteById(id);
    }

    @Override
    public HistorialMedicoDto findHistorialMedicoByEstudiante(Estudiante estudiante) {
        Optional<HistorialMedico> HMFound = historialMedicoRepository.findHistorialMedicosByEstudiante(estudiante);
        if (HMFound.isEmpty()) throw new NotFoundException("EL historial medico del estudiante " + estudiante.getPrimerNombre() + " no fue encontrado");
        return historialMedicoMapper.historialMedicoEntityToHistorialMedicoDto(HMFound.get());
    }

    @Override
    public List<HistorialMedicoDto> findHistorialMedicoByEPS(String eps) {
        List<HistorialMedico> HMMatched = historialMedicoRepository.findHistorialMedicoByEPS(eps);

        if (HMMatched.isEmpty()) throw new NotFoundException("Ningun historial medico fue encontrado");

        List<HistorialMedicoDto> HMToReturn = new ArrayList<>();

        HMMatched.forEach( historialMedico -> {
            HistorialMedicoDto mappedHM = historialMedicoMapper.historialMedicoEntityToHistorialMedicoDto(historialMedico);
            HMToReturn.add(mappedHM);
        } );

        return HMToReturn;
    }
}
