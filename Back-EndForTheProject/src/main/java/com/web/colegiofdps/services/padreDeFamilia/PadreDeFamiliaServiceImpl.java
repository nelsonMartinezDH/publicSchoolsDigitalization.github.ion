package com.web.colegiofdps.services.padreDeFamilia;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.PadreDeFamilia;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.PadreDeFamiliaMapper;
import com.web.colegiofdps.repositories.PadreDeFamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PadreDeFamiliaServiceImpl implements PadreDeFamiliaService{

    private final PadreDeFamiliaRepository padreDeFamiliaRepository;

    private final PadreDeFamiliaMapper padreDeFamiliaMapper;

    @Autowired
    public PadreDeFamiliaServiceImpl(PadreDeFamiliaRepository padreDeFamiliaRepository,
                                     PadreDeFamiliaMapper padreDeFamiliaMapper) {
        this.padreDeFamiliaRepository = padreDeFamiliaRepository;
        this.padreDeFamiliaMapper = padreDeFamiliaMapper;
    }

    @Override
    public PadreDeFamiliaDto savePadreDeFamilia(PadreDeFamiliaDto padreDeFamilia) {
        PadreDeFamilia parentToSave = padreDeFamiliaMapper.parentDtoToParentEntity(padreDeFamilia);
        PadreDeFamilia parentSaved = padreDeFamiliaRepository.save(parentToSave);
        return padreDeFamiliaMapper.parentEntityToParentDto(parentSaved);
    }

    @Override
    public PadreDeFamiliaDto updatePadreDeFamiliaByid(Long id, PadreDeFamiliaDto padreDeFamilia) {
        Optional<PadreDeFamilia> parentConsulted = padreDeFamiliaRepository.findById(id);

        if (parentConsulted.isEmpty()) throw new NotFoundException("Padre de familia con ID "+ id + " hasn't been found");

        PadreDeFamilia pf = parentConsulted.get();

        if (padreDeFamilia.primerNombre() != null) pf.setPrimerNombre(padreDeFamilia.primerNombre());
        if (padreDeFamilia.primerApellido() != null) pf.setPrimerApellido(padreDeFamilia.primerApellido());
        if (padreDeFamilia.segundoApellido() != null) pf.setSegundoApellido(padreDeFamilia.segundoApellido());
        if (padreDeFamilia.email() != null) pf.setEmail(padreDeFamilia.email());
        if (padreDeFamilia.direccionResidencia() != null) pf.setDireccionResidencia(padreDeFamilia.direccionResidencia());

        PadreDeFamilia updatedParent = padreDeFamiliaRepository.save(pf);

        return padreDeFamiliaMapper.parentEntityToParentDto(updatedParent);
    }

    @Override
    public PadreDeFamiliaDto findPadreDeFamiliaByid(Long id) {
        Optional<PadreDeFamilia> padreDeFamilia = padreDeFamiliaRepository.findById(id);

        if (padreDeFamilia.isEmpty()) throw new NotFoundException("No se ha encontrado ningun padre de familia");

        return padreDeFamiliaMapper.parentEntityToParentDto(padreDeFamilia.get());
    }

    @Override
    public List<PadreDeFamiliaDto> findAllPadresDeFamilia() {
        List<PadreDeFamilia> parents = padreDeFamiliaRepository.findAll();

        if (parents.isEmpty()) throw new NotFoundException("No se ha encontrado ningun padre de familia");

        List<PadreDeFamiliaDto> allParents = new ArrayList<>();

        parents.forEach( padreDeFamilia -> {
            PadreDeFamiliaDto p = padreDeFamiliaMapper.parentEntityToParentDto(padreDeFamilia);
            allParents.add(p);
        });

        return allParents;
    }

    @Override
    public void deletePadreDeFamiliaByid(Long id) {
        Optional<PadreDeFamilia> parentToDelete = padreDeFamiliaRepository.findById(id);

        if (parentToDelete.isEmpty()) throw new NotFoundException("No se ha encontrado ningun padre de familia");

        padreDeFamiliaRepository.deleteById(id);
    }

    @Override
    public PadreDeFamiliaDto findPadreDeFamiliaByemail(String email) {
        Optional<PadreDeFamilia> parentMatch = padreDeFamiliaRepository.findPadreDeFamiliaByEmail(email);

        if (parentMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ningun padre de familia");

        return padreDeFamiliaMapper.parentEntityToParentDto(parentMatch.get());
    }

    @Override
    public List<PadreDeFamiliaDto> findPadreDeFamiliaByEstudiante(Estudiante estudiante) {
        List<PadreDeFamilia> parentsMatch = padreDeFamiliaRepository.findPadresDeFamiliaByEstudiantes(estudiante);

        if (parentsMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ningun padre de familia");

        List<PadreDeFamiliaDto> parentToReturn = new ArrayList<>();

        parentsMatch.forEach( padreDeFamilia -> {
            PadreDeFamiliaDto mappedParent = padreDeFamiliaMapper.parentEntityToParentDto(padreDeFamilia);
            parentToReturn.add(mappedParent);
        });

        return parentToReturn;
    }

    @Override
    public List<PadreDeFamiliaDto> findPadreDeFamuliaByPrimerNombreAndPrimerApellido(String primerNombre, String primerApellido) {
        List<PadreDeFamilia> parentsMatch = padreDeFamiliaRepository.findPadreDeFamiliasByPrimerNombreAndPrimerApellido(primerNombre, primerApellido);

        if (parentsMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ningun padre de familia");

        List<PadreDeFamiliaDto> parentToReturn = new ArrayList<>();

        parentsMatch.forEach( padreDeFamilia -> {
            PadreDeFamiliaDto mappedParent = padreDeFamiliaMapper.parentEntityToParentDto(padreDeFamilia);
            parentToReturn.add(mappedParent);
        });

        return parentToReturn;
    }
}
