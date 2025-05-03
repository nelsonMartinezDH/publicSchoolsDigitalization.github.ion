package com.web.colegiofdps.controllers;

import com.web.colegiofdps.dtos.Acudiente.AcudienteDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.acudiente.AcudienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/acudientes")
public class AcudienteController {

    private final AcudienteService acudienteService;

    @Autowired
    public AcudienteController(AcudienteService acudienteService) {
        this.acudienteService = acudienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcudienteDto> getAcudienteById(@PathVariable Long id){
        try {
            AcudienteDto res = acudienteService.findAcudientebyId(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AcudienteDto>> getAllAcudientes(){
        try {
            List<AcudienteDto> res = acudienteService.findAllAcudientes();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<AcudienteDto> getAcudienteByEmail(@PathVariable String email){
        try {
            AcudienteDto res = acudienteService.findAcudientebyEmail(email);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ocupacion")
    public ResponseEntity<List<AcudienteDto>> getAcudienteByOcupacion(@RequestParam("work") String ocupacion){
        try {
            List<AcudienteDto> res = acudienteService.findAcudienteByOcupacion(ocupacion);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name")
    public ResponseEntity<List<AcudienteDto>> getAcudienteByNombre(@RequestParam("name") String nombre){
        try {
            List<AcudienteDto> res = acudienteService.findAcudientebyNombre(nombre);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<AcudienteDto> postAcudiente(@RequestBody AcudienteDto acudienteDto){
        AcudienteDto res = acudienteService.saveAcudiente(acudienteDto);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcudienteDto> putAcudiente(@PathVariable Long id, @RequestBody AcudienteDto acudienteDto){
        try {
            AcudienteDto res = acudienteService.updateAcudientebyId(id, acudienteDto);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAcudiente(@PathVariable Long id){
        try{
            acudienteService.deleteAcudientebyId(id);
            return ResponseEntity.ok().body("Acudiente eliminado");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
