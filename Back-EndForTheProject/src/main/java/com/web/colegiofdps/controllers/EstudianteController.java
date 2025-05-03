package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.DocumentoIdentidad;
import com.web.colegiofdps.Entities.Matricula;
import com.web.colegiofdps.dtos.Estudiante.EstudianteDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.estudiante.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping()
    public ResponseEntity<EstudianteDto> postEstudiante(@RequestBody EstudianteDto estudianteDto){
        EstudianteDto res = estudianteService.saveEstudiante(estudianteDto);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDto> putEstudiante(@PathVariable Long id, @RequestBody EstudianteDto estudiante){
        try {
            EstudianteDto res = estudianteService.updateEstudianteById(id, estudiante);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> getEstudianteById(@PathVariable Long id){
        try {
            EstudianteDto res = estudianteService.findEstudianteById(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<EstudianteDto>> getAllEstudiantes(){
        try {
            List<EstudianteDto> res = estudianteService.findAllEstudiantes();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEstudiante(@PathVariable Long id){
        try {
            estudianteService.deleteEstudianteById(id);
            return ResponseEntity.ok().body("El estudiante con ID " + id + " ha sido eliminado");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{primerNombre}/{primerApellido}")
    public ResponseEntity<List<EstudianteDto>> getEstudianteByPrimerNombreAndPrimerApellido(@PathVariable("primerNombre") String primerNombre, @PathVariable("primerApellido") String primerApellido){
        try {
            List<EstudianteDto> res = estudianteService.findEstudianteByPrimerNombreAndPrimerApellido(primerNombre, primerApellido);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/matricula")
    public ResponseEntity<EstudianteDto> getEstudianteByMatricula(@RequestParam("codigoMatricula") Long id){
        try {
            Matricula matricula = new Matricula();
            matricula.setIdMatricula(id);
            EstudianteDto res = estudianteService.findEstudianteByMatricula(matricula);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/documentoIdentidad")
    public ResponseEntity<EstudianteDto> getEstudianteByDocumentoIdentidad(@RequestParam("numeroDocumento") Integer numeroDocumento){
        try {
            DocumentoIdentidad documentoIdentidad = new DocumentoIdentidad();
            documentoIdentidad.setNumeroDocumento(numeroDocumento);
            EstudianteDto res = estudianteService.findEstudianteByDocumentoIdentidad(documentoIdentidad);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
