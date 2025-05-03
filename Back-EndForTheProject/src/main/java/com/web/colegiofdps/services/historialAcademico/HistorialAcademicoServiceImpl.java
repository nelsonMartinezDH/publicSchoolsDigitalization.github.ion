package com.web.colegiofdps.services.historialAcademico;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.HistorialAcademico;
import com.web.colegiofdps.dtos.HistorialAcademico.HistorialAcademicoDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.HistorialAcademicoMapper;
import com.web.colegiofdps.repositories.HistorialAcademicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HistorialAcademicoServiceImpl implements HistorialAcademicoService{

    private final HistorialAcademicoRepository historialAcademicoRepository;

    private final HistorialAcademicoMapper historialAcademicoMapper;

    @Autowired
    public HistorialAcademicoServiceImpl(HistorialAcademicoRepository historialAcademicoRepository,
                                         HistorialAcademicoMapper historialAcademicoMapper) {
        this.historialAcademicoRepository = historialAcademicoRepository;
        this.historialAcademicoMapper = historialAcademicoMapper;
    }

    @Override
    public HistorialAcademicoDto saveHistorialAcademico(HistorialAcademicoDto historialAcademico) {
        HistorialAcademico HAToSave = historialAcademicoMapper.historialAcademicoDtoToHistorialAcademicoEntity(historialAcademico);
        HistorialAcademico HASaved = historialAcademicoRepository.save(HAToSave);
        return historialAcademicoMapper.historialAcademicoEntityToHistorialAcademicoDto(HASaved);
    }

    @Override
    public HistorialAcademicoDto updateHistorialAcademicoByid(Long id, HistorialAcademicoDto historialAcademico) {
        Optional<HistorialAcademico> HAConsulted = historialAcademicoRepository.findById(id);

        if (HAConsulted.isEmpty()) throw new NotFoundException("El historial academico con ID " + id + " no fue encontrado");

        HistorialAcademico ha = HAConsulted.get();

        if (historialAcademico.promedioAnteriorObtenido() != null) ha.setPromedioAnteriorObtenido(historialAcademico.promedioAnteriorObtenido());
        if (historialAcademico.añoHistorialAcademico() != null) ha.setAñoHistorialAcademico(historialAcademico.añoHistorialAcademico());

        HistorialAcademico updatedHA = historialAcademicoRepository.save(ha);
        return historialAcademicoMapper.historialAcademicoEntityToHistorialAcademicoDto(updatedHA);
    }

    @Override
    public HistorialAcademicoDto findHistorialAcademicoById(Long id) {
        Optional<HistorialAcademico> historialAcademico = historialAcademicoRepository.findById(id);
        if (historialAcademico.isEmpty()) throw new NotFoundException("El historial academmico con ID " + id + " no fue encontrado");
        return historialAcademicoMapper.historialAcademicoEntityToHistorialAcademicoDto(historialAcademico.get());
    }

    @Override
    public List<HistorialAcademicoDto> findAllHistorialesAcademicos() {
        List<HistorialAcademico> historialAcademicoList = historialAcademicoRepository.findAll();

        if (historialAcademicoList.isEmpty()) throw new NotFoundException("No se ha encontrado ningun historial academico");

        List<HistorialAcademicoDto> allHA = new ArrayList<>();

        historialAcademicoList.forEach( historialAcademico -> {
            HistorialAcademicoDto h = historialAcademicoMapper.historialAcademicoEntityToHistorialAcademicoDto(historialAcademico);
            allHA.add(h);
        } );

        return allHA;
    }

    @Override
    public void deleteHistorialAcademicoByid(Long id) {
        Optional<HistorialAcademico> HAToDelete = historialAcademicoRepository.findById(id);
        if (HAToDelete.isEmpty()) throw new NotFoundException("El historial academico con ID " + id + " no fue encontrado");
        historialAcademicoRepository.deleteById(id);
    }

    @Override
    public HistorialAcademicoDto findHistorialAcademicoByEstudiante(Estudiante estudiante) {
        Optional<HistorialAcademico> matchedHA = historialAcademicoRepository.findHistorialAcademicoByEstudiante(estudiante);
        if (matchedHA.isEmpty()) throw new NotFoundException("El historial academico del estudiante " + estudiante.getPrimerNombre() + " no fue encontrado");
        return historialAcademicoMapper.historialAcademicoEntityToHistorialAcademicoDto(matchedHA.get());
    }

    @Override
    public List<HistorialAcademicoDto> findHistorialAcademicoByAño(Year añoHistorialAcademico) {
        List<HistorialAcademico> HAMatch = historialAcademicoRepository.findHistorialAcademicosByAñoHistorialAcademico(añoHistorialAcademico);

        if (HAMatch.isEmpty()) throw new NotFoundException("Ningun historial academico fue encontrado");

        List<HistorialAcademicoDto> HAToReturn = new ArrayList<>();

        HAMatch.forEach( historialAcademico -> {
            HistorialAcademicoDto mappedHA = historialAcademicoMapper.historialAcademicoEntityToHistorialAcademicoDto(historialAcademico);
            HAToReturn.add(mappedHA);
        } );

        return HAToReturn;
    }
}
