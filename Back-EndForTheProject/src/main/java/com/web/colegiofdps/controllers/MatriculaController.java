package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.EstadoMatricula;
import com.web.colegiofdps.dtos.Matricula.MatriculaDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.matricula.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/matricula")
public class MatriculaController {

    private final MatriculaService matriculaService;

    @Autowired
    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping()
    public ResponseEntity<MatriculaDto> postMatricula(@RequestBody MatriculaDto matricula){
        MatriculaDto res = matriculaService.saveMatricula(matricula);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDto> putMatricula(@PathVariable Long id, @RequestBody MatriculaDto matricula){
        try{
            MatriculaDto res = matriculaService.updateMatriculaByid(id, matricula);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDto> getMatriculaById(@PathVariable Long id){
        try{
            MatriculaDto res = matriculaService.findMatriculaById(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<MatriculaDto>> getAllMatriculas(){
        try{
            List<MatriculaDto> res = matriculaService.findAllMatriculas();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatricula(@PathVariable Long id){
        try {
            matriculaService.deleteMatriculaById(id);
            return ResponseEntity.ok().body("Matricula eliminada");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/matricula/estadoMatricula")
    public ResponseEntity<List<MatriculaDto>> getMatriculaByEstadoMatricula(@RequestParam("estadoMatricula") EstadoMatricula estadoMatricula){
        try{
            List<MatriculaDto> res = matriculaService.findMatriculaByEstadoMatricula(estadoMatricula);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estado/{idMatricula}")
    public ResponseEntity<EstadoMatricula> getEstadoMatriculaByMatriculaID(@PathVariable("idMatricula") Long id){
        try{
            EstadoMatricula res = matriculaService.findEstadoMatriculaByIdMatricula(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fecha")
        public ResponseEntity<List<MatriculaDto>> getMatriculaByFecha(@RequestParam("fecha") Date fecha){
        try{
            List<MatriculaDto> res = matriculaService.findMatriculaByFechaMatricula(fecha);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/iniciarMatricula")
    public ResponseEntity<MatriculaDto> iniciarProcesoDeMatricula(@RequestBody MatriculaDto matriculaDto){
        MatriculaDto res = matriculaService.iniciarProcesoDeMatricula(matriculaDto);
        return ResponseEntity.ok().body(res);
    }
}
