package com.web.colegiofdps.services.matricula;

import com.web.colegiofdps.Entities.*;
import com.web.colegiofdps.dtos.Matricula.MatriculaDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.MatriculaMapper;
import com.web.colegiofdps.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService{

    private final MatriculaRepository matriculaRepository;
    private final EstudianteRepository estudianteRepository;
    private final MatriculaMapper matriculaMapper;
    private final PadreDeFamiliaRepository padreDeFamiliaRepository;
    private final DocumentoIdentidadRepository documentoIdentidadRepository;
    private final HistorialAcademicoRepository historialAcademicoRepository;
    private final HistorialMedicoRepository historialMedicoRepository;

    @Autowired
    public MatriculaServiceImpl(MatriculaRepository matriculaRepository,
                                EstudianteRepository estudianteRepository,
                                MatriculaMapper matriculaMapper,
                                PadreDeFamiliaRepository padreDeFamiliaRepository,
                                DocumentoIdentidadRepository documentoIdentidadRepository,
                                HistorialAcademicoRepository historialAcademicoRepository,
                                HistorialMedicoRepository historialMedicoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.estudianteRepository = estudianteRepository;
        this.matriculaMapper = matriculaMapper;
        this.padreDeFamiliaRepository = padreDeFamiliaRepository;
        this.documentoIdentidadRepository = documentoIdentidadRepository;
        this.historialAcademicoRepository = historialAcademicoRepository;
        this.historialMedicoRepository = historialMedicoRepository;
    }

    @Override
    public MatriculaDto saveMatricula(MatriculaDto matricula) {
        Matricula matriculaToSave = matriculaMapper.matriculaDtoToMatriculaEntity(matricula);
        Matricula matriculaSaved = matriculaRepository.save(matriculaToSave);
        return matriculaMapper.matriculaEntityToMatriculaDto(matriculaSaved);
    }

    @Override
    public MatriculaDto updateMatriculaByid(Long id, MatriculaDto matricula) {
        Optional<Matricula> matriculaConsulted = matriculaRepository.findById(id);

        if (matriculaConsulted.isEmpty()) throw new NotFoundException("Matricula con ID " + id + " not found");

        Matricula ma = matriculaConsulted.get();

        if (matricula.fechaMatricula() != null) ma.setFechaMatricula(matricula.fechaMatricula());
        if (matricula.comentariosEnMatricula() != null) ma.setComentariosEnMatricula(matricula.comentariosEnMatricula());
        if (matricula.estadoMatricula() != null) ma.setEstadoMatricula(matricula.estadoMatricula());

        Matricula updatedMatricula = matriculaRepository.save(ma);

        return matriculaMapper.matriculaEntityToMatriculaDto(updatedMatricula);
    }

    @Override
    public MatriculaDto findMatriculaById(Long id) {
        Optional<Matricula> matricula = matriculaRepository.findById(id);

        if (matricula.isEmpty()) throw new NotFoundException("No se ha encontrado ninnguna matricula");

        return matriculaMapper.matriculaEntityToMatriculaDto(matricula.get());
    }

    @Override
    public List<MatriculaDto> findAllMatriculas() {
        List<Matricula> matriculas = matriculaRepository.findAll();

        if (matriculas.isEmpty()) throw new NotFoundException("No se ha encontrado ninguna matricula");

        List<MatriculaDto> allMatriculas = new ArrayList<>();

        matriculas.forEach( matricula -> {
            MatriculaDto m = matriculaMapper.matriculaEntityToMatriculaDto(matricula);
            allMatriculas.add(m);
        });

        return allMatriculas;
    }

    @Override
    public void deleteMatriculaById(Long id) {
        Optional<Matricula> matriculaToDelete = matriculaRepository.findById(id);

        if (matriculaToDelete.isEmpty()) throw new NotFoundException("No se ha encontrado ninguna matricula");

        matriculaRepository.deleteById(id);
    }

    @Override
    public MatriculaDto findMatriculaByEstudiante(Estudiante estudiante) {
        Optional<Matricula> matriculaMatch = matriculaRepository.findMatriculaByEstudiante(estudiante);

        if (matriculaMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ninguna matricula");

        return matriculaMapper.matriculaEntityToMatriculaDto(matriculaMatch.get());
    }

    @Override
    public List<MatriculaDto> findMatriculaByEstadoMatricula(EstadoMatricula estadoMatricula) {
        List<Matricula> matriculasMatch = matriculaRepository.findMatriculasByEstadoMatricula(estadoMatricula);

        if (matriculasMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ningun matricula");

        List<MatriculaDto> matriculaToReturn = new ArrayList<>();

        matriculasMatch.forEach( matricula -> {
            MatriculaDto mappedMatricula = matriculaMapper.matriculaEntityToMatriculaDto(matricula);
            matriculaToReturn.add(mappedMatricula);
        });

        return matriculaToReturn;
    }

    @Override
    public EstadoMatricula findEstadoMatriculaByIdMatricula(Long id) {
        Optional<Matricula> matricula = matriculaRepository.findById(id);

        if (matricula.isPresent()){
            return matricula.get().getEstadoMatricula();
        } else {
            throw new NotFoundException("La matricula con ID " + id + " no ha sido encontrada");
        }

    }

    @Override
    public List<MatriculaDto> findMatriculaByFechaMatricula(Date fechaMatricula) {
        List<Matricula> matriculasMatch = matriculaRepository.findMatriculasByFechaMatricula(fechaMatricula);

        if (matriculasMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ninguna matricula");

        List<MatriculaDto> matriculaToReturn = new ArrayList<>();

        matriculasMatch.forEach( matricula -> {
            MatriculaDto mappedMatricula = matriculaMapper.matriculaEntityToMatriculaDto(matricula);
            matriculaToReturn.add(mappedMatricula);
        });

        return matriculaToReturn;
    }

    @Override
    public MatriculaDto iniciarProcesoDeMatricula(MatriculaDto matriculaDto) {

        Matricula matricula = matriculaMapper.matriculaDtoToMatriculaEntity(matriculaDto);

        Estudiante estudiante = estudianteRepository.save(matricula.getEstudiante());
        DocumentoIdentidad documentoIdentidad = documentoIdentidadRepository.save(matricula.getEstudiante().getDocumentoIdentidad());
        HistorialMedico historialMedico = historialMedicoRepository.save(matricula.getEstudiante().getHistorialMedico());
        HistorialAcademico historialAcademico = historialAcademicoRepository.save(matricula.getEstudiante().getHistorialAcademico());

        Matricula newMatricula = matriculaRepository.save(matricula);

        return matriculaMapper.matriculaEntityToMatriculaDto(newMatricula);
    }
}
