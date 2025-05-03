package com.web.colegiofdps.mappers;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.Estudiante.EstudianteDto;
import com.web.colegiofdps.dtos.Estudiante.EstudianteToSaveDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EstudianteMapper {

    EstudianteMapper mapper = Mappers.getMapper( EstudianteMapper.class );

    @Mapping(target = "idEstudiante", source = "idEstudiante")
    @Mapping(target = "primerNombre", source = "primerNombre")
    @Mapping(target = "segundoNombre", source = "segundoNombre")
    @Mapping(target = "primerApellido", source = "primerApellido")
    @Mapping(target = "segundoApellido", source = "segundoApellido")
    @Mapping(target = "fechaNacimiento", source = "fechaNacimiento")
    @Mapping(target = "sexoEstudiante", source = "sexoEstudiante")
    @Mapping(target = "ciudadNacimiento", source = "ciudadNacimiento")
    @Mapping(target = "departamentoNacimiento", source = "departamentoNacimiento")
    @Mapping(target = "departamentoResidencia", source = "departamentoResidencia")
    @Mapping(target = "ciudadResidencia", source = "ciudadResidencia")
    @Mapping(target = "direccionResidencia", source = "direccionResidencia")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "padresDeFamilia", source = "padresDeFamilia")
    @Mapping(target = "documentosEstudiante", source = "documentosEstudiante")
    @Mapping(target = "telefonos", source = "telefonos")
    @Mapping(target = "colegiosAnteriores", source = "colegiosAnteriores")
    @Mapping(target = "matricula", ignore = true)
    @Mapping(target = "historialMedico", ignore = true)
    @Mapping(target = "acudientes", source = "acudientes")
    @Mapping(target = "historialAcademico", source = "historialAcademicoDto", ignore = true)
    @Mapping(target = "documentoIdentidad", source = "documentoIdentidadDto", ignore = true)
    @Mapping(target = "grados", source = "grados")
    @Mapping(target = "citasPsicologicas", source = "citasPsicologicas")
    Estudiante studentDtoToStudentEntity(EstudianteDto estudianteDto);

    @InheritInverseConfiguration
    EstudianteDto studentEntityToStudentDto(Estudiante estudiante);
}
