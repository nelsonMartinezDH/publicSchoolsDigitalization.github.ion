package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.PadreDeFamilia.PadreDeFamiliaDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.padreDeFamilia.PadreDeFamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/padreDeFamilia")
public class PadreDeFamiliaController {

    private final PadreDeFamiliaService padreDeFamiliaService;

    @Autowired
    public PadreDeFamiliaController(PadreDeFamiliaService padreDeFamiliaService) {
        this.padreDeFamiliaService = padreDeFamiliaService;
    }

    @PostMapping()
    public ResponseEntity<PadreDeFamiliaDto> postPadreDeFamilia(@RequestBody PadreDeFamiliaDto padreDeFamilia){
        PadreDeFamiliaDto res = padreDeFamiliaService.savePadreDeFamilia(padreDeFamilia);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PadreDeFamiliaDto> putPadreDeFamilia(@PathVariable Long id, @RequestBody PadreDeFamiliaDto padreDeFamilia){
        try{
            PadreDeFamiliaDto res = padreDeFamiliaService.updatePadreDeFamiliaByid(id, padreDeFamilia);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PadreDeFamiliaDto> getPadreDeFamiliaById(@PathVariable Long id){
        try{
            PadreDeFamiliaDto res = padreDeFamiliaService.findPadreDeFamiliaByid(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<PadreDeFamiliaDto>> getAllPadresDeFamilia(){
        try{
            List<PadreDeFamiliaDto> res = padreDeFamiliaService.findAllPadresDeFamilia();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePadreDeFamilia(@PathVariable Long id){
        try {
            padreDeFamiliaService.deletePadreDeFamiliaByid(id);
            return ResponseEntity.ok().body("Padre de familia eliminado");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<PadreDeFamiliaDto> getPadreDeFamiliaByEmail(@PathVariable String email){
        try {
            PadreDeFamiliaDto res = padreDeFamiliaService.findPadreDeFamiliaByemail(email);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estudiante")
    public ResponseEntity<List<PadreDeFamiliaDto>> getPadreDeFamiliaByEstudiante(@RequestParam("primerNombre") String primerNombre,
                                                                                 @RequestParam("segundoNombre") String segundoNombre,
                                                                                 @RequestParam("primerApellido") String primerApellido,
                                                                                 @RequestParam("segundoApellido") String segundoApellido){
        try{
            Estudiante estudiante = new Estudiante();
            estudiante.setPrimerNombre(primerNombre);
            estudiante.setSegundoNombre(segundoNombre);
            estudiante.setPrimerApellido(primerApellido);
            estudiante.setSegundoApellido(segundoApellido);

            List<PadreDeFamiliaDto> res = padreDeFamiliaService.findPadreDeFamiliaByEstudiante(estudiante);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{primerNombre}/{primerApellido}")
    public ResponseEntity<List<PadreDeFamiliaDto>> getPadreDeFamiliaByPrimerNombreAndPrimerApellido(@PathVariable("primerNombre") String primerNombre, @PathVariable("primerApellido") String primerApellido){
        try {
            List<PadreDeFamiliaDto> res = padreDeFamiliaService.findPadreDeFamuliaByPrimerNombreAndPrimerApellido(primerNombre, primerApellido);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
