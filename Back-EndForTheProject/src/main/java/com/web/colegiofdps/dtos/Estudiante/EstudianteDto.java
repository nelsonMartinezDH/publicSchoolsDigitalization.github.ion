package com.web.colegiofdps.dtos.Estudiante;

import com.web.colegiofdps.Entities.*;
import com.web.colegiofdps.dtos.DocumentoIdentidad.DocumentoIdentidadDto;
import com.web.colegiofdps.dtos.HistorialAcademico.HistorialAcademicoDto;
import com.web.colegiofdps.dtos.HistorialMedico.HistorialMedicoDto;
import com.web.colegiofdps.dtos.Matricula.MatriculaDto;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public record EstudianteDto (
        Long idEstudiante,
        String primerNombre,
        String segundoNombre,
        String primerApellido,
        String segundoApellido,
        Date fechaNacimiento,
        Sexo sexoEstudiante,
        String ciudadNacimiento,
        String departamentoNacimiento,
        String departamentoResidencia,
        String ciudadResidencia,
        String direccionResidencia,
        String email,
        List<PadreDeFamilia> padresDeFamilia,
        List<DocumentosEstudiante> documentosEstudiante,
        List<Telefono> telefonos,
        List<ColegiosAnteriores> colegiosAnteriores,
        List<Acudiente> acudientes,
        HistorialAcademicoDto historialAcademicoDto,
        DocumentoIdentidadDto documentoIdentidadDto,
        List<Grado> grados,
        List<CitaPsicologica> citasPsicologicas
        )
{
    public List<PadreDeFamilia> padresDeFamilia(){
        return Collections.unmodifiableList(padresDeFamilia);
    }
    public List<DocumentosEstudiante> documentosEstudiante(){ return Collections.unmodifiableList(documentosEstudiante); }
    public List<Telefono> telefonos(){ return Collections.unmodifiableList(telefonos); }
    public List<ColegiosAnteriores> colegiosAnteriores(){ return Collections.unmodifiableList(colegiosAnteriores); }
    public List<Acudiente> acudientes(){ return Collections.unmodifiableList(acudientes); }
    public List<Grado> grados(){ return Collections.unmodifiableList(grados); }
    public List<CitaPsicologica> citasPsicologicas(){ return Collections.unmodifiableList(citasPsicologicas); }
}
