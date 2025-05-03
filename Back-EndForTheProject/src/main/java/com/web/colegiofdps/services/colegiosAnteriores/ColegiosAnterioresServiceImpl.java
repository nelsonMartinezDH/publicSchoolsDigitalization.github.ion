package com.web.colegiofdps.services.colegiosAnteriores;

import com.web.colegiofdps.Entities.ColegiosAnteriores;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.ColegiosAnteriores.ColegiosAnterioresDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.ColegiosMapper;
import com.web.colegiofdps.repositories.ColegiosAnterioresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ColegiosAnterioresServiceImpl implements ColegiosAnterioresService{

    private final ColegiosAnterioresRepository colegiosAnterioresRepository;

    private final ColegiosMapper colegiosAnterioresMapper;

    @Autowired
    public ColegiosAnterioresServiceImpl(ColegiosAnterioresRepository colegiosAnterioresRepository,
                                         ColegiosMapper colegiosMapper) {
        this.colegiosAnterioresRepository = colegiosAnterioresRepository;
        this.colegiosAnterioresMapper = colegiosMapper;
    }

    @Override
    public ColegiosAnterioresDto saveColegiosAnteriores(ColegiosAnterioresDto colegiosAnteriores) {
        ColegiosAnteriores CAToSave = colegiosAnterioresMapper.colegiosAnterioresDtoToColegiosAnterioresEntity(colegiosAnteriores);
        ColegiosAnteriores CASaved = colegiosAnterioresRepository.save(CAToSave);
        return colegiosAnterioresMapper.colegiosAnterioresEntityToColegiosAnterioresDto(CASaved);
    }

    @Override
    public ColegiosAnterioresDto updateColegiosAnteriores(Long id, ColegiosAnterioresDto colegiosAnteriores) {
        Optional<ColegiosAnteriores> CAConsulted = colegiosAnterioresRepository.findById(id);

        if (CAConsulted.isEmpty()) throw new NotFoundException("El colegio con ID " + id + " No ha sido encontrado");

        ColegiosAnteriores ca = CAConsulted.get();

        if (colegiosAnteriores.nombreColegio() != null) ca.setNombreColegio(colegiosAnteriores.nombreColegio());

        ColegiosAnteriores updatedCA = colegiosAnterioresRepository.save(ca);

        return colegiosAnterioresMapper.colegiosAnterioresEntityToColegiosAnterioresDto(updatedCA);
    }

    @Override
    public ColegiosAnterioresDto findColegiosAnterioresByid(Long id) {
        Optional<ColegiosAnteriores> colegioAnterior = colegiosAnterioresRepository.findById(id);
        if (colegioAnterior.isEmpty()) throw new NotFoundException("El colegio con ID " + id + " no ha sido encontrado");
        return colegiosAnterioresMapper.colegiosAnterioresEntityToColegiosAnterioresDto(colegioAnterior.get());
    }

    @Override
    public List<ColegiosAnterioresDto> findAllcolegiosAnteriores() {

        List<ColegiosAnteriores> matchedCA = colegiosAnterioresRepository.findAll();
        if (matchedCA.isEmpty()) throw new NotFoundException("Ningun colegio ha sido encontrado");
        List<ColegiosAnterioresDto> allCA = new ArrayList<>();

        matchedCA.forEach( colegiosAnteriores -> {
            ColegiosAnterioresDto mappedCA = colegiosAnterioresMapper.colegiosAnterioresEntityToColegiosAnterioresDto(colegiosAnteriores);
            allCA.add(mappedCA);
        } );

        return allCA;
    }

    @Override
    public void deleteColegiosAnteriores(Long id) {
        Optional<ColegiosAnteriores> CAToDelete = colegiosAnterioresRepository.findById(id);
        if (CAToDelete.isEmpty()) throw new NotFoundException("El colegio con ID " + id + " no ha sido encontrado");
        colegiosAnterioresRepository.deleteById(id);
    }

    @Override
    public List<ColegiosAnterioresDto> findColegiosAnterioresByEstudiante(Estudiante estudiante) {
        List<ColegiosAnteriores> CPMatched = colegiosAnterioresRepository.findByEstudiante(estudiante);

        if (CPMatched.isEmpty()) throw new NotFoundException("Ningun colegio anterior hallado");

        List<ColegiosAnterioresDto> CAToReturn = new ArrayList<>();

        CPMatched.forEach( colegiosAnteriores -> {
            ColegiosAnterioresDto mappedCA = colegiosAnterioresMapper.colegiosAnterioresEntityToColegiosAnterioresDto(colegiosAnteriores);
            CAToReturn.add(mappedCA);
        } );

        return CAToReturn;
    }

    @Override
    public List<ColegiosAnterioresDto> findColegiosAnterioresByNombre(String nombreColegio) {

        List<ColegiosAnteriores> CAsMatched = colegiosAnterioresRepository.findByNombreColegio(nombreColegio);

        if (CAsMatched.isEmpty()) throw new NotFoundException("Ningun colegio ha sido encontrado");

        List<ColegiosAnterioresDto> CAToReturn = new ArrayList<>();

        CAsMatched.forEach( colegiosAnteriores -> {
            ColegiosAnterioresDto mappedCA = colegiosAnterioresMapper.colegiosAnterioresEntityToColegiosAnterioresDto(colegiosAnteriores);
            CAToReturn.add(mappedCA);
        } );

        return CAToReturn;
    }
}
