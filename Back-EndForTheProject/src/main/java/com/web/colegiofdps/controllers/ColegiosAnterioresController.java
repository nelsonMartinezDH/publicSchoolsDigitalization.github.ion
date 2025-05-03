package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.ColegiosAnteriores.ColegiosAnterioresDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.colegiosAnteriores.ColegiosAnterioresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/colegiosAnteriores")
public class ColegiosAnterioresController {

    private final ColegiosAnterioresService colegiosAnterioresService;

    @Autowired
    public ColegiosAnterioresController(ColegiosAnterioresService colegiosAnterioresService) {
        this.colegiosAnterioresService = colegiosAnterioresService;
    }

    @PostMapping()
    public ResponseEntity<ColegiosAnterioresDto> postColegioAnterior(@RequestBody ColegiosAnterioresDto colegiosAnteriores){
        ColegiosAnterioresDto res = colegiosAnterioresService.saveColegiosAnteriores(colegiosAnteriores);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColegiosAnterioresDto> putColegioAnterior(@PathVariable Long id, @RequestBody ColegiosAnterioresDto colegiosAnteriores){
        try{
            ColegiosAnterioresDto res = colegiosAnterioresService.updateColegiosAnteriores(id, colegiosAnteriores);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColegiosAnterioresDto> getColegiosAnterioresById(@PathVariable Long id){
        try{
            ColegiosAnterioresDto res = colegiosAnterioresService.findColegiosAnterioresByid(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<ColegiosAnterioresDto>> getAllColegiosAnteriores(){
        try {
            List<ColegiosAnterioresDto> res = colegiosAnterioresService.findAllcolegiosAnteriores();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteColegiosAnteriores(@PathVariable Long id){
        try{
            colegiosAnterioresService.deleteColegiosAnteriores(id);
            return ResponseEntity.ok().body("El colegio con ID " + id + " ha sido eliminado");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estudiante")
    public ResponseEntity<List<ColegiosAnterioresDto>> getColegiosAnterioresByEstudiante(@RequestParam("primerNombre") String primerNombre,
                                                                                         @RequestParam("segundoNombre") String segundoNombre,
                                                                                         @RequestParam("primerApellido") String primerApellido,
                                                                                         @RequestParam("segundoApellido") String segundoApellido){
        try {
            Estudiante estudiante = new Estudiante();
            estudiante.setPrimerNombre(primerNombre);
            estudiante.setSegundoNombre(segundoNombre);
            estudiante.setPrimerApellido(primerApellido);
            estudiante.setSegundoApellido(segundoApellido);

            List<ColegiosAnterioresDto> res = colegiosAnterioresService.findColegiosAnterioresByEstudiante(estudiante);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name")
    public ResponseEntity<List<ColegiosAnterioresDto>> getColegiosAnterioresByNombre(@RequestParam("name") String nombre){
        try {
            List<ColegiosAnterioresDto> res = colegiosAnterioresService.findColegiosAnterioresByNombre(nombre);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
