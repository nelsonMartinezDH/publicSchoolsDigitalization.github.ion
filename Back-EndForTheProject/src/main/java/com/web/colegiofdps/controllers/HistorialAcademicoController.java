package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.HistorialAcademico.HistorialAcademicoDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.historialAcademico.HistorialAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("api/v1/historialAcademico")
public class HistorialAcademicoController {

    private final HistorialAcademicoService historialAcademicoService;

    @Autowired
    public HistorialAcademicoController(HistorialAcademicoService historialAcademicoService) {
        this.historialAcademicoService = historialAcademicoService;
    }

    @PostMapping()
    public ResponseEntity<HistorialAcademicoDto> postHistorialAcademico(@RequestBody HistorialAcademicoDto historialAcademico){
        HistorialAcademicoDto res = historialAcademicoService.saveHistorialAcademico(historialAcademico);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialAcademicoDto> putHistorialAcademico(@PathVariable Long id, @RequestBody HistorialAcademicoDto historialAcademicoDto){
        try{
            HistorialAcademicoDto res = historialAcademicoService.updateHistorialAcademicoByid(id, historialAcademicoDto);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialAcademicoDto> getHistorialAcademicoById(@PathVariable Long id){
        try{
            HistorialAcademicoDto res = historialAcademicoService.findHistorialAcademicoById(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<HistorialAcademicoDto>> getAllHistorialesAcademicos(){
        try{
            List<HistorialAcademicoDto> res = historialAcademicoService.findAllHistorialesAcademicos();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHistorialAcademico(@PathVariable Long id){
        try {
            historialAcademicoService.deleteHistorialAcademicoByid(id);
            return ResponseEntity.ok().body("Historial academico eliminado");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estudiante")
    public ResponseEntity<HistorialAcademicoDto> getHistorialAcademicoByEstudiante(@RequestParam("primerNombre") String primerNombre,
                                                                                   @RequestParam("segundoNombre") String segundoNombre,
                                                                                   @RequestParam("primerApellido") String primerApellido,
                                                                                   @RequestParam("segundoApellido") String segundoApellido){
        try{
            Estudiante estudiante = new Estudiante();
            estudiante.setPrimerNombre(primerNombre);
            estudiante.setSegundoNombre(segundoNombre);
            estudiante.setPrimerApellido(primerApellido);
            estudiante.setSegundoApellido(segundoApellido);

            HistorialAcademicoDto res = historialAcademicoService.findHistorialAcademicoByEstudiante(estudiante);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/año")
    public ResponseEntity<List<HistorialAcademicoDto>> getHistorialAcademicoByAño(@RequestParam("año") Year año){
        try{
            List<HistorialAcademicoDto> res = historialAcademicoService.findHistorialAcademicoByAño(año);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
