package com.web.colegiofdps.services.grado;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.Grado;
import com.web.colegiofdps.dtos.Grado.GradoDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.GradoMapper;
import com.web.colegiofdps.repositories.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradoServiceImpl implements GradoService{

    private final GradoRepository gradoRepository;

    private final GradoMapper gradoMapper;

    @Autowired
    public GradoServiceImpl(GradoRepository gradoRepository,
                            GradoMapper gradoMapper) {
        this.gradoRepository = gradoRepository;
        this.gradoMapper = gradoMapper;
    }

    @Override
    public GradoDto saveGrado(GradoDto grado) {
        Grado gradoToSave = gradoMapper.gradoDtoToGradoEntity(grado);
        Grado gradoSaved = gradoRepository.save(gradoToSave);
        return gradoMapper.gradoEntityToGradoDto(gradoSaved);
    }

    @Override
    public GradoDto updateGradoByid(Long id, GradoDto grado) {
        Optional<Grado> gradoConsulted = gradoRepository.findById(id);

        if (gradoConsulted.isEmpty()) throw new NotFoundException("El grado con ID " + id + " no fue encontrado");

        Grado g = gradoConsulted.get();

        if (grado.nombre() != null) g.setNombre(grado.nombre());
        if (grado.fechaDeMatricula() != null) g.setFechaDeMatricula(grado.fechaDeMatricula());

        Grado updatedGrado = gradoRepository.save(g);
        return gradoMapper.gradoEntityToGradoDto(updatedGrado);
    }

    @Override
    public GradoDto findGradoById(Long id) {
        Optional<Grado> foundGrado = gradoRepository.findById(id);
        if (foundGrado.isEmpty()) throw new NotFoundException("El grado con ID " + id + " no fue encontrado");
        return gradoMapper.gradoEntityToGradoDto(foundGrado.get());
    }

    @Override
    public List<GradoDto> findAllGrados() {

        List<Grado> grados = gradoRepository.findAll();

        if (grados.isEmpty()) throw new NotFoundException("No se ha encontrado ningun grado");

        List<GradoDto> allGrados = new ArrayList<>();

        grados.forEach( grado -> {
            GradoDto g = gradoMapper.gradoEntityToGradoDto(grado);
            allGrados.add(g);
        } );

        return allGrados;
    }

    @Override
    public void deleteGradoById(Long id) {
        Optional<Grado> foundGrado = gradoRepository.findById(id);
        if (foundGrado.isEmpty()) throw new NotFoundException("EL grado con ID " + id + " no fue encontrado");
        gradoRepository.deleteById(id);
    }

    @Override
    public GradoDto findGradoByEstudiante(Estudiante estudiante) {
        Optional<Grado> foundGrado = gradoRepository.findGradoByEstudiantes(estudiante);
        if (foundGrado.isEmpty()) throw new NotFoundException("EL grado del estudiante " + estudiante.getPrimerNombre() + " no fue encontrado");
        return gradoMapper.gradoEntityToGradoDto(foundGrado.get());
    }

    @Override
    public GradoDto findGradosByName(String nombreGrado) {
        Optional<Grado> foundGrado = gradoRepository.findGradoByNombre(nombreGrado);
        if (foundGrado.isEmpty()) throw new NotFoundException("El grado " + nombreGrado + " no fue encontrado");
        return gradoMapper.gradoEntityToGradoDto(foundGrado.get());
    }
}
