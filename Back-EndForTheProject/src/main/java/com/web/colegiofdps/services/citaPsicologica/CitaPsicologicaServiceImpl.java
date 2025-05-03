package com.web.colegiofdps.services.citaPsicologica;

import com.web.colegiofdps.Entities.Acudiente;
import com.web.colegiofdps.Entities.CitaPsicologica;
import com.web.colegiofdps.Entities.EstadoCitaPsicologica;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.CitaPsicologica.CitaPsicologicaDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.CitaPsicologicaMapper;
import com.web.colegiofdps.repositories.CitaPsicologicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitaPsicologicaServiceImpl implements CitaPsicologicaService{

    private final CitaPsicologicaRepository citaPsicologicaRepository;
    private final CitaPsicologicaMapper citaPsicologicaMapper;

    @Autowired
    public CitaPsicologicaServiceImpl(CitaPsicologicaRepository citaPsicologicaRepository,
                                      CitaPsicologicaMapper citaPsicologicaMapper) {
        this.citaPsicologicaRepository = citaPsicologicaRepository;
        this.citaPsicologicaMapper = citaPsicologicaMapper;
    }

    @Override
    public CitaPsicologicaDto saveCitaPsicologica(CitaPsicologicaDto citaPsicologica) {
        CitaPsicologica citaPsicologicaTosave = citaPsicologicaMapper.citaPsicologicaDtoToCitaPsicologicaEntity(citaPsicologica);
        CitaPsicologica citaPsicologicaSaved = citaPsicologicaRepository.save(citaPsicologicaTosave);
        return citaPsicologicaMapper.citaPsicologicaEntityToCitaPsicologicaDto(citaPsicologicaSaved);
    }

    @Override
    public CitaPsicologicaDto updateCitaPsicologicaById(Long id, CitaPsicologicaDto citaPsicologica) {
        Optional<CitaPsicologica> citaPsicologicaConsulted = citaPsicologicaRepository.findById(id);

        if (citaPsicologicaConsulted.isEmpty()) throw new NotFoundException("No se ha encontrado ninguna cita psicologica");

        CitaPsicologica cp = citaPsicologicaConsulted.get();

        if (citaPsicologica.fecha_HoraDeCita() != null) cp.setFechaYHoraDeCita(citaPsicologica.fecha_HoraDeCita());
        if (citaPsicologica.estadoCitaPsicologica() != null) cp.setEstadoCitaPsicologica(citaPsicologica.estadoCitaPsicologica());
        if (citaPsicologica.motivoCita() != null) cp.setMotivoCita(citaPsicologica.motivoCita());

        CitaPsicologica updatedCitaPsicologica = citaPsicologicaRepository.save(cp);

        return citaPsicologicaMapper.citaPsicologicaEntityToCitaPsicologicaDto(updatedCitaPsicologica);
    }

    @Override
    public CitaPsicologicaDto findCitaPsicologicaById(Long id) {

        Optional<CitaPsicologica> citaPsicologica = citaPsicologicaRepository.findById(id);

        if (citaPsicologica.isEmpty()) throw new NotFoundException("Cita psicologica with ID " + id + " NOT FOUND");

        return citaPsicologicaMapper.citaPsicologicaEntityToCitaPsicologicaDto(citaPsicologica.get());
    }

    @Override
    public List<CitaPsicologicaDto> findAllCitasPsicologicas() {

        List<CitaPsicologica> citaPsicologicas = citaPsicologicaRepository.findAll();

        if (citaPsicologicas.isEmpty()) throw new NotFoundException("Ninguna cita psicologica encontrada");

        List<CitaPsicologicaDto> allCitasPsicologicas = new ArrayList<>();

        citaPsicologicas.forEach( citaPsicologica -> {
            CitaPsicologicaDto cp = citaPsicologicaMapper.citaPsicologicaEntityToCitaPsicologicaDto(citaPsicologica);
            allCitasPsicologicas.add(cp);
        } );

        return allCitasPsicologicas;
    }

    @Override
    public void deleteCitaPsicologicaById(Long id) {
        Optional<CitaPsicologica> CPToDelete = citaPsicologicaRepository.findById(id);

        if (CPToDelete.isEmpty()) throw new NotFoundException("Cita psicologica with ID \" + id + \" NOT FOUND");

        citaPsicologicaRepository.deleteById(id);
    }

    @Override
    public List<CitaPsicologicaDto> findCitaPsicologicaByEstadoCita(EstadoCitaPsicologica estadoCitaPsicologica) {

        List<CitaPsicologica> CPsMatch = citaPsicologicaRepository.findCitaPsicologicaByEstadoCitaPsicologica(estadoCitaPsicologica);

        if (CPsMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ninguna cita psicologica con estado " + estadoCitaPsicologica);

        List<CitaPsicologicaDto> CPToReturn = new ArrayList<>();

        CPsMatch.forEach( citaPsicologica -> {
            CitaPsicologicaDto mappedCP = citaPsicologicaMapper.citaPsicologicaEntityToCitaPsicologicaDto(citaPsicologica);
            CPToReturn.add(mappedCP);
        } );

        return CPToReturn;
    }

    @Override
    public List<CitaPsicologicaDto> findCitaPsicologicaByEstudiante(Estudiante estudiante) {

        List<CitaPsicologica> CPMatch = citaPsicologicaRepository.findCitaPsicologicasByEstudiantes(estudiante);

        if (CPMatch.isEmpty()) throw new NotFoundException("Cita psicologica of student " + estudiante.getPrimerNombre() + " NOT FOUND");

        List<CitaPsicologicaDto> CPToReturn = new ArrayList<>();
        CPMatch.forEach( citaPsicologica -> {
            CitaPsicologicaDto mappedCP = citaPsicologicaMapper.citaPsicologicaEntityToCitaPsicologicaDto(citaPsicologica);
            CPToReturn.add(mappedCP);
        } );

        return CPToReturn;
    }

    @Override
    public List<CitaPsicologicaDto> findCitaPsicologicaByFechaYHora(LocalDateTime fechaYHora) {

        List<CitaPsicologica> CPMatch = citaPsicologicaRepository.findCitaPsicologicasByFechaYHoraDeCita(fechaYHora);

        if (CPMatch.isEmpty()) throw new NotFoundException("Ninguna cita psicologica ha sido encontrada");

        List<CitaPsicologicaDto> CPToReturn = new ArrayList<>();

        CPMatch.forEach( citaPsicologica -> {
            CitaPsicologicaDto mappedCP = citaPsicologicaMapper.citaPsicologicaEntityToCitaPsicologicaDto(citaPsicologica);
            CPToReturn.add(mappedCP);
        } );

        return CPToReturn;
    }
}
