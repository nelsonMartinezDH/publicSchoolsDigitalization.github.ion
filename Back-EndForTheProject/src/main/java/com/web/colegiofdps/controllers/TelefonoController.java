package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.TipoTelefono;
import com.web.colegiofdps.dtos.Telefono.TelefonoDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.telefono.TelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/telefono")
public class TelefonoController {

    private final TelefonoService telefonoService;

    @Autowired
    public TelefonoController(TelefonoService telefonoService) {
        this.telefonoService = telefonoService;
    }

    @PostMapping()
    public ResponseEntity<TelefonoDto> postTelefono(@RequestBody TelefonoDto telefono){
        TelefonoDto res = telefonoService.saveTelefono(telefono);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefonoDto> putTelefono(@PathVariable Long id, @RequestBody TelefonoDto telefono){
        try{
            TelefonoDto res = telefonoService.updateTelefonoByid(id, telefono);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefonoDto> getTelefonoById(@PathVariable Long id){
        try{
            TelefonoDto res = telefonoService.findTelefonoByid(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<TelefonoDto>> getAllTelefonos(){
        try{
            List<TelefonoDto> res = telefonoService.findAllTelefonos();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelefono(@PathVariable Long id){
        try {
            telefonoService.deleteTelefonoByid(id);
            return ResponseEntity.ok().body("Telefono eliminado");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/numeroTelefonico")
    public ResponseEntity<TelefonoDto> getTelefonoByNumeroTelefonico(@RequestParam("numeroTelefonico") String numeroTelefonico){
        try{
            TelefonoDto res = telefonoService.findTelefonoByNumeroTelefonico(numeroTelefonico);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tipoTelefono")
    public ResponseEntity<List<TelefonoDto>> getTelefonoByTipoTelefono(@RequestParam("tipoTelefono") TipoTelefono tipoTelefono){
        try{
            List<TelefonoDto> res = telefonoService.findTelefonoByTipoTelefono(tipoTelefono);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
