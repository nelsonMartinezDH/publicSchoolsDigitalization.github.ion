package com.web.colegiofdps.services.estudiante;

import com.web.colegiofdps.Entities.Acudiente;
import com.web.colegiofdps.Entities.DocumentoIdentidad;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.Entities.Matricula;
import com.web.colegiofdps.dtos.Acudiente.AcudienteDto;
import com.web.colegiofdps.dtos.Acudiente.AcudienteToSaveDto;
import com.web.colegiofdps.dtos.Estudiante.EstudianteDto;
import com.web.colegiofdps.dtos.Estudiante.EstudianteToSaveDto;
import com.web.colegiofdps.dtos.Matricula.MatriculaDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.EstudianteMapper;
import com.web.colegiofdps.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    private final EstudianteRepository estudianteRepository;

    private final EstudianteMapper estudianteMapper;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository, EstudianteMapper estudianteMapper) {
        this.estudianteRepository = estudianteRepository;
        this.estudianteMapper = estudianteMapper;
    }

    @Override
    public EstudianteDto saveEstudiante(EstudianteDto estudiante){
        Estudiante estudianteToSave = estudianteMapper.studentDtoToStudentEntity(estudiante);
        Estudiante estudianteSaved = estudianteRepository.save(estudianteToSave);
        return estudianteMapper.studentEntityToStudentDto(estudianteSaved);
    }

    @Override
    public EstudianteDto updateEstudianteById(Long id, EstudianteDto estudiante){
        Optional<Estudiante> estudianteConsultado = estudianteRepository.findById(id);

        if (estudianteConsultado.isEmpty()) throw new NotFoundException("Estudiante con ID "+ id + " not found");

        Estudiante es = estudianteConsultado.get();

        if (estudiante.primerNombre() != null) es.setPrimerNombre(estudiante.primerNombre());
        if (estudiante.segundoNombre() != null) es.setSegundoNombre(estudiante.segundoNombre());
        if (estudiante.primerApellido() != null) es.setPrimerApellido(estudiante.primerApellido());
        if (estudiante.segundoApellido() != null) es.setSegundoApellido(estudiante.segundoApellido());
        if (estudiante.fechaNacimiento() != null) es.setFechaNacimiento(estudiante.fechaNacimiento());
        if (estudiante.primerNombre() != null) es.setPrimerNombre(estudiante.primerNombre());
        if (estudiante.sexoEstudiante() != null) es.setSexoEstudiante(estudiante.sexoEstudiante());
        if (estudiante.ciudadNacimiento() != null) es.setCiudadNacimiento(estudiante.ciudadNacimiento());
        if (estudiante.ciudadResidencia() != null) es.setCiudadResidencia(estudiante.ciudadResidencia());
        if (estudiante.direccionResidencia() != null) es.setDireccionResidencia(estudiante.direccionResidencia());
        if (estudiante.email() != null) es.setEmail(estudiante.email());


        Estudiante updatedStudent = estudianteRepository.save(es);

        return estudianteMapper.studentEntityToStudentDto(updatedStudent);
    }

    @Override
    public List<EstudianteDto> findAllEstudiantes(){

        List<Estudiante> estudiantes = estudianteRepository.findAll();

        if (estudiantes.isEmpty()) throw new NotFoundException("No se ha encontrado ningun estudiante");

        List<EstudianteDto> allStudents = new ArrayList<>();

        estudiantes.forEach( estudiante -> {
            EstudianteDto e = estudianteMapper.studentEntityToStudentDto(estudiante);
            allStudents.add(e);
        });

        return allStudents;
    }

    @Override
    public EstudianteDto findEstudianteById(Long id){

        Optional<Estudiante> estudiante = estudianteRepository.findById(id);

        if (estudiante.isEmpty()) throw new NotFoundException("No se ha encontrado ningun estudiante");

        return estudianteMapper.studentEntityToStudentDto(estudiante.get());
    }

    @Override
    public void deleteEstudianteById(Long id){
        Optional<Estudiante> studentToDelete = estudianteRepository.findById(id);

        if (studentToDelete.isEmpty()) throw new NotFoundException("No se ha encontrado ningun estudiante");

        estudianteRepository.deleteById(id);
    }

    @Override
    public List<EstudianteDto> findEstudianteByPrimerNombreAndPrimerApellido(String primerNombre, String primerApellido){

        List<Estudiante> studentsMatch = estudianteRepository.findByPrimerNombreAndPrimerApellido(primerNombre, primerApellido);

        if (studentsMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ningun estudiante");

        List<EstudianteDto> studentToReturn = new ArrayList<>();

        studentsMatch.forEach( estudiante -> {
            EstudianteDto mappedStudent = estudianteMapper.studentEntityToStudentDto(estudiante);
            studentToReturn.add(mappedStudent);
        });

        return studentToReturn;
    }

    @Override
    public EstudianteDto findEstudianteByMatricula(Matricula matricula){

        Optional<Estudiante> studentMatch = estudianteRepository.findEstudianteByMatricula(matricula);

        if (studentMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ningun estudiante");

        return estudianteMapper.studentEntityToStudentDto(studentMatch.get());
    }

    @Override
    public EstudianteDto findEstudianteByDocumentoIdentidad(DocumentoIdentidad documentoIdentidad){

        Optional<Estudiante> studentMatch = estudianteRepository.findEstudiantesByDocumentoIdentidad(documentoIdentidad);

        if (studentMatch.isEmpty()) throw new NotFoundException("No se ha encontrado ningun estudiante");

        return estudianteMapper.studentEntityToStudentDto(studentMatch.get());
    }
}
