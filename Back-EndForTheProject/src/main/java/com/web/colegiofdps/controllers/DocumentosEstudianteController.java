package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.EstadoDocumento;
import com.web.colegiofdps.Entities.Estudiante;
import com.web.colegiofdps.dtos.DocumentosEstudiante.DocumentosEstudianteDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.documentosEstudiante.DocumentosEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/documentosEstudiante")
public class DocumentosEstudianteController {

    private final DocumentosEstudianteService documentosEstudianteService;

    @Autowired
    public DocumentosEstudianteController(DocumentosEstudianteService documentosEstudianteService) {
        this.documentosEstudianteService = documentosEstudianteService;
    }

    @PostMapping()
    public ResponseEntity<DocumentosEstudianteDto> postDocumentoEstudiante(@RequestBody DocumentosEstudianteDto documentosEstudiante){
        DocumentosEstudianteDto res = documentosEstudianteService.saveDocumentosEstudiante(documentosEstudiante);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentosEstudianteDto> putDocumentoEstudiante(@PathVariable Long id, @RequestBody DocumentosEstudianteDto documentosEstudiante){
        try {
            DocumentosEstudianteDto res = documentosEstudianteService.updateDocumentosEstudianteById(id, documentosEstudiante);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentosEstudianteDto> getDocumentosEstudianteById(@PathVariable Long id){
        try {
            DocumentosEstudianteDto res = documentosEstudianteService.findDocumentosEstudianteById(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<DocumentosEstudianteDto>> getAllDocumentosEstudiante(){
        try {
            List<DocumentosEstudianteDto> res = documentosEstudianteService.findAllDocumentosEstudiante();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocumentoEstudiante(@PathVariable Long id){
        try {
            documentosEstudianteService.deleteDocumentosEstudianteById(id);
            return ResponseEntity.ok().body("El documento con ID " + id + " ha sido eliminado");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nombreDocumento")
    public ResponseEntity<DocumentosEstudianteDto> getDocumentosEstudianteByNombreDocumento(@RequestParam("nombreDocumento") String nombreDocumento){
        try {
            DocumentosEstudianteDto res = documentosEstudianteService.findDocumentosEstudianteByNombreDocumento(nombreDocumento);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estudiante")
    public ResponseEntity<DocumentosEstudianteDto> getDocumentosEstudianteByEstudiante(@RequestParam("primerNombre") String primerNombre,
                                                                                       @RequestParam("segundoNombre") String segundoNombre,
                                                                                       @RequestParam("primerApellido") String primerApellido,
                                                                                       @RequestParam("segundoApellido") String segundoApellido){
        try {
            Estudiante estudiante = new Estudiante();
            estudiante.setPrimerNombre(primerNombre);
            estudiante.setSegundoNombre(segundoNombre);
            estudiante.setPrimerApellido(primerApellido);
            estudiante.setSegundoApellido(segundoApellido);

            DocumentosEstudianteDto res = documentosEstudianteService.findDocumentosEstudianteByEstudiante(estudiante);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tipoDocumento")
    public ResponseEntity<List<DocumentosEstudianteDto>> getDocumentosEstudianteByTipoDocumento(@RequestParam("tipoDocumento") String tipoDocumento){
        try {
            List<DocumentosEstudianteDto> res = documentosEstudianteService.findDocumentosEstudianteByTipoDocumento(tipoDocumento);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estadoDocumento")
    public ResponseEntity<List<DocumentosEstudianteDto>> getDocumentosEstudianteByestadoDocumento(@RequestParam("estadoDocumento") EstadoDocumento estadoDocumento){
        try {
            List<DocumentosEstudianteDto> res = documentosEstudianteService.findDocumentosEstudianteByEstadoDocumento(estadoDocumento);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
