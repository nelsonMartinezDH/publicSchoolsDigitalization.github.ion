package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.Grado.GradoDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.grado.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/grado")
public class GradoController {

    private final GradoService gradoService;

    @Autowired
    public GradoController(GradoService gradoService) {
        this.gradoService = gradoService;
    }

    @PostMapping()
    public ResponseEntity<GradoDto> postGrado(@RequestBody GradoDto grado){
        GradoDto res = gradoService.saveGrado(grado);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradoDto> putGrado(@PathVariable Long id, @RequestBody GradoDto grado){
        try{
            GradoDto res = gradoService.updateGradoByid(id, grado);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradoDto> getGradoById(@PathVariable Long id){
        try{
            GradoDto res = gradoService.findGradoById(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<GradoDto>> getAllGrados(){
        try{
            List<GradoDto> res = gradoService.findAllGrados();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCitaPsicologica(@PathVariable Long id){
        try {
            gradoService.deleteGradoById(id);
            return ResponseEntity.ok().body("Grado con ID " + id + " eliminada");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estudiante")
    public ResponseEntity<GradoDto> getGradoByEstudiante(@RequestParam("primerNombre") String primerNombre,
                                                         @RequestParam("segundoNombre") String segundoNombre,
                                                         @RequestParam("primerApellido") String primerApellido,
                                                         @RequestParam("segundoApellido") String segundoApellido){
        try{
            Estudiante estudiante = new Estudiante();
            estudiante.setPrimerNombre(primerNombre);
            estudiante.setSegundoNombre(segundoNombre);
            estudiante.setPrimerApellido(primerApellido);
            estudiante.setSegundoApellido(segundoApellido);

            GradoDto res = gradoService.findGradoByEstudiante(estudiante);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nombreGrado")
    public ResponseEntity<GradoDto> getGradoByName(@RequestParam("nombreGrado") String nombreGrado){
        try{
            GradoDto res = gradoService.findGradosByName(nombreGrado);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
