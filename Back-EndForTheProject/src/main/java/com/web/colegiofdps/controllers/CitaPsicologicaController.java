package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.EstadoCitaPsicologica;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.CitaPsicologica.CitaPsicologicaDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.citaPsicologica.CitaPsicologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/citaPsicologica")
public class CitaPsicologicaController {

    private final CitaPsicologicaService citaPsicologicaService;

    @Autowired
    public CitaPsicologicaController(CitaPsicologicaService citaPsicologicaService) {
        this.citaPsicologicaService = citaPsicologicaService;
    }

    @PostMapping()
    public ResponseEntity<CitaPsicologicaDto> postCitaPsicologica(@RequestBody CitaPsicologicaDto citaPsicologica){
        CitaPsicologicaDto res = citaPsicologicaService.saveCitaPsicologica(citaPsicologica);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaPsicologicaDto> putCitaPsicologica(@PathVariable Long id, @RequestBody CitaPsicologicaDto citaPsicologica){
        try{
            CitaPsicologicaDto res = citaPsicologicaService.updateCitaPsicologicaById(id, citaPsicologica);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaPsicologicaDto> getCitaPsicologicaById(@PathVariable Long id){
        try{
            CitaPsicologicaDto res = citaPsicologicaService.findCitaPsicologicaById(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<CitaPsicologicaDto>> getAllCitasPsicologicas(){
        try{
            List<CitaPsicologicaDto> res = citaPsicologicaService.findAllCitasPsicologicas();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCitaPsicologica(@PathVariable Long id){
        try {
            citaPsicologicaService.deleteCitaPsicologicaById(id);
            return ResponseEntity.ok().body("Cita psicologica eliminada");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estadoCita")
    public ResponseEntity<List<CitaPsicologicaDto>> getCitaPsicologicaByEstadoCita(@RequestParam("estadoCita") EstadoCitaPsicologica estadoCita){
        try{
            List<CitaPsicologicaDto> res = citaPsicologicaService.findCitaPsicologicaByEstadoCita(estadoCita);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estudiante")
    public ResponseEntity<List<CitaPsicologicaDto>> getCitaPsicologicaByEstudiante(@RequestParam("primerNombre") String primerNombre,
                                                                                   @RequestParam("segundoNombre") String segundoNombre,
                                                                                   @RequestParam("primerApellido") String primerApellido,
                                                                                   @RequestParam("segundoApellido") String segundoApellido){
        try{
            Estudiante estudiante = new Estudiante();
            estudiante.setPrimerNombre(primerNombre);
            estudiante.setSegundoNombre(segundoNombre);
            estudiante.setPrimerApellido(primerApellido);
            estudiante.setSegundoApellido(segundoApellido);

            List<CitaPsicologicaDto> res = citaPsicologicaService.findCitaPsicologicaByEstudiante(estudiante);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fechaYHora")
    public ResponseEntity<List<CitaPsicologicaDto>> getCitaPsicologicaByFechaYHora(@RequestParam("fechaYHora") LocalDateTime fechaYHora){
        try{
            List<CitaPsicologicaDto> res = citaPsicologicaService.findCitaPsicologicaByFechaYHora(fechaYHora);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
