package com.web.colegiofdps.services.acudiente;

import com.web.colegiofdps.Entities.Acudiente;
import com.web.colegiofdps.Entities.Matricula;
import com.web.colegiofdps.dtos.Acudiente.AcudienteDto;
import com.web.colegiofdps.dtos.Matricula.MatriculaDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.AcudienteMapper;
import com.web.colegiofdps.repositories.AcudienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AcudienteServiceImpl implements AcudienteService{

    private final AcudienteRepository acudienteRepository;
    private final AcudienteMapper acudienteMapper;

    @Autowired
    public AcudienteServiceImpl(AcudienteRepository acudienteRepository,
                                AcudienteMapper acudienteMapper) {
        this.acudienteRepository = acudienteRepository;
        this.acudienteMapper = acudienteMapper;
    }

    @Override
    public AcudienteDto saveAcudiente(AcudienteDto acudiente) {
        Acudiente acudienteToSave = acudienteMapper.acudienteDtoToAcudienteEntity(acudiente);
        Acudiente acudienteSaved = acudienteRepository.save(acudienteToSave);
        return acudienteMapper.acudienteEntityToAcudienteDto(acudienteSaved);
    }

    @Override
    public AcudienteDto updateAcudientebyId(Long id, AcudienteDto Acudiente) {
        Optional<Acudiente> acudienteConsulted = acudienteRepository.findById(id);

        if (acudienteConsulted.isEmpty()) throw new NotFoundException("Ningun acudiente fue encontrado");

        Acudiente ac = acudienteConsulted.get();

        if (Acudiente.primerNombre() != null) ac.setPrimerNombre(Acudiente.primerNombre());
        if (Acudiente.primerApellido() != null) ac.setPrimerApellido(Acudiente.primerApellido());
        if (Acudiente.segundoApellido() != null) ac.setSegundoApellido(Acudiente.segundoApellido());
        if (Acudiente.ocupacion() != null) ac.setOcupacion(Acudiente.ocupacion());
        if (Acudiente.email() != null) ac.setEmail(Acudiente.email());

        Acudiente updatedAcudiente = acudienteRepository.save(ac);

        return acudienteMapper.acudienteEntityToAcudienteDto(updatedAcudiente);

    }

    @Override
    public AcudienteDto findAcudientebyId(Long id) {

        Optional<Acudiente> acudiente = acudienteRepository.findById(id);
        if (acudiente.isEmpty()) throw new NotFoundException("No se ha encontrado ningun acudiente");
        return acudienteMapper.acudienteEntityToAcudienteDto(acudiente.get());
    }

    @Override
    public List<AcudienteDto> findAllAcudientes() {
        List<Acudiente> acudientes = acudienteRepository.findAll();

        if (acudientes.isEmpty()) throw new NotFoundException("No se ha encontrado ningun acudiente");

        List<AcudienteDto> allAcudientes = new ArrayList<>();

        acudientes.forEach( acudiente -> {
            AcudienteDto a = acudienteMapper.acudienteEntityToAcudienteDto(acudiente);
            allAcudientes.add(a);
        });

        return allAcudientes;
    }

    @Override
    public void deleteAcudientebyId(Long id) {
        Optional<Acudiente> acudienteToDelete = acudienteRepository.findById(id);
        if (acudienteToDelete.isEmpty()) throw new NotFoundException("No se ha encontrado ningun acudiente");
        acudienteRepository.deleteById(id);
    }

    @Override
    public AcudienteDto findAcudientebyEmail(String email) {

        Optional<Acudiente> acudienteMatch = acudienteRepository.findByEmail(email);
        if (acudienteMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ningun acudiente");
        return acudienteMapper.acudienteEntityToAcudienteDto(acudienteMatch.get());
    }

    @Override
    public List<AcudienteDto> findAcudienteByOcupacion(String ocupacion) {
        List<Acudiente> acudienteMatch = acudienteRepository.findAcudientesByOcupacion(ocupacion);

        if (acudienteMatch.isEmpty()) throw new NotFoundException("Ningun acudiente fue encontrado");

        List<AcudienteDto> acudienteToReturn = new ArrayList<>();

        acudienteMatch.forEach(acudiente -> {
            AcudienteDto mappedAcudiente = acudienteMapper.acudienteEntityToAcudienteDto(acudiente);
            acudienteToReturn.add(mappedAcudiente);
        });

        return acudienteToReturn;
    }

    @Override
    public List<AcudienteDto> findAcudientebyNombre(String nombre) {
        List<Acudiente> acudienteMatch = acudienteRepository.findAcudientesByPrimerNombre(nombre);

        if (acudienteMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ningun acudiente");

        List<AcudienteDto> acudienteToReturn = new ArrayList<>();

        acudienteMatch.forEach( acudiente -> {
            AcudienteDto mappedAcudiente = acudienteMapper.acudienteEntityToAcudienteDto(acudiente);
            acudienteToReturn.add(mappedAcudiente);
        } );

        return acudienteToReturn;
    }
}
