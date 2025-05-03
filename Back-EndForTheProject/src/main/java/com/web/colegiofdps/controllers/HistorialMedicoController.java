package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.HistorialMedico.HistorialMedicoDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.historialMedico.HistorialMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/historialMedico")
public class HistorialMedicoController {

    private final HistorialMedicoService historialMedicoService;

    @Autowired
    public HistorialMedicoController(HistorialMedicoService historialMedicoService) {
        this.historialMedicoService = historialMedicoService;
    }

    @PostMapping()
    public ResponseEntity<HistorialMedicoDto> postHistorialMedico(@RequestBody HistorialMedicoDto historialMedico){
        HistorialMedicoDto res = historialMedicoService.saveHistorialMedico(historialMedico);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialMedicoDto> putHistorialMedico(@PathVariable Long id, @RequestBody HistorialMedicoDto historialMedico){
        try{
            HistorialMedicoDto res = historialMedicoService.updateHistorialMedicoByid(id, historialMedico);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialMedicoDto> getHistorialMedicoById(@PathVariable Long id){
        try{
            HistorialMedicoDto res = historialMedicoService.findHistorialMedicoByid(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<HistorialMedicoDto>> getAllHistorialesMedicos(){
        try{
            List<HistorialMedicoDto> res = historialMedicoService.findAllHistorialesMedicos();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHistorialMedico(@PathVariable Long id){
        try {
            historialMedicoService.deleteHistorialMedicoByid(id);
            return ResponseEntity.ok().body("Historial medico eliminado");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estudiante")
    public ResponseEntity<HistorialMedicoDto> getHistorialMedicoByEstudiante(@RequestParam("primerNombre") String primerNombre,
                                                                             @RequestParam("segundoNombre") String segundoNombre,
                                                                             @RequestParam("primerApellido") String primerApellido,
                                                                             @RequestParam("segundoApellido") String segundoApellido){
        try{
            Estudiante estudiante = new Estudiante();
            estudiante.setPrimerNombre(primerNombre);
            estudiante.setSegundoNombre(segundoNombre);
            estudiante.setPrimerApellido(primerApellido);
            estudiante.setSegundoApellido(segundoApellido);

            HistorialMedicoDto res = historialMedicoService.findHistorialMedicoByEstudiante(estudiante);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/EPS")
    public ResponseEntity<List<HistorialMedicoDto>> getHistorialMedicoByEPS(@RequestParam("eps") String eps){
        try{
            List<HistorialMedicoDto> res = historialMedicoService.findHistorialMedicoByEPS(eps);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
