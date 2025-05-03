package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.DocumentoIdentidad.DocumentoIdentidadDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.documentoIdentidad.DocumentoIdentidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/documentoIdentidad")
public class DocumentoIdentidadController {

    private final DocumentoIdentidadService documentoIdentidadService;

    @Autowired
    public DocumentoIdentidadController(DocumentoIdentidadService documentoIdentidadService) {
        this.documentoIdentidadService = documentoIdentidadService;
    }

    @PostMapping()
    public ResponseEntity<DocumentoIdentidadDto> postDocumentoIdentidad(@RequestBody DocumentoIdentidadDto documentoIdentidad){
        DocumentoIdentidadDto res = documentoIdentidadService.saveDocumentoIdentidad(documentoIdentidad);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoIdentidadDto> putDocumentoIdentidad(@PathVariable Long id, @RequestBody DocumentoIdentidadDto documentoIdentidad){
        try{
            DocumentoIdentidadDto res = documentoIdentidadService.updateDocumentoIdentidadByid(id, documentoIdentidad);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoIdentidadDto> getDocumentoIdentidadById(@PathVariable Long id){
        try {
            DocumentoIdentidadDto res = documentoIdentidadService.findDocumentoIdentidadById(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<DocumentoIdentidadDto>> getAllDocumentosIdentidad(){
        try{
            List<DocumentoIdentidadDto> res = documentoIdentidadService.findAllDocumentoIdentidad();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocumentoIdentidad(@PathVariable Long id){
        try {
            documentoIdentidadService.deleteDocumentoIdentidadById(id);
            return ResponseEntity.ok().body("El documento de identidad con ID " + id + " ha sido eliminado");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/numeroDocumento")
    public ResponseEntity<DocumentoIdentidadDto> getDocumentoIdentidadByNumeroDocumento(@RequestParam("numeroDeDocumento") Integer numeroDocumento){
        try {
            DocumentoIdentidadDto res = documentoIdentidadService.findDocumentoIdentidadByNumeroDocumento(numeroDocumento);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fechaExpedicion")
    public ResponseEntity<List<DocumentoIdentidadDto>> getDocumentoIdentidadByFechaDeExpedicion(@RequestParam("fechaExpedicion") Date fechaExpedicion){
        try {
            List<DocumentoIdentidadDto> res = documentoIdentidadService.findDocumentoIdentidadByFechaDeExpedicion(fechaExpedicion);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estudiante")
    public ResponseEntity<DocumentoIdentidadDto> getDocumentoIdentidadByEstudiante(@RequestParam("primerNombre") String primerNombre,
                                                                                   @RequestParam("segundoNombre") String segundoNombre,
                                                                                   @RequestParam("primerApellido") String primerApellido,
                                                                                   @RequestParam("segundoApellido") String segundoApellido){
        try{
            Estudiante estudiante = new Estudiante();
            estudiante.setPrimerNombre(primerNombre);
            estudiante.setSegundoNombre(segundoNombre);
            estudiante.setPrimerApellido(primerApellido);
            estudiante.setSegundoApellido(segundoApellido);

            DocumentoIdentidadDto res = documentoIdentidadService.findDocumentoIdentidadByEstudiante(estudiante);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
