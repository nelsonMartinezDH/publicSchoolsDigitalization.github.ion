package com.web.colegiofdps.controllers;

import com.web.colegiofdps.Entities.EstadoNotificacion;
import com.web.colegiofdps.dtos.Notificacion.NotificacionDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.services.notificacion.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/notificacionController")
public class NotificacionController {

    private final NotificacionService notificacionService;

    @Autowired
    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @PostMapping()
    public ResponseEntity<NotificacionDto> postNotificacion(@RequestBody NotificacionDto notificacion){
        NotificacionDto res = notificacionService.saveNotificacion(notificacion);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacionDto> putNotificacion(@PathVariable Long id, @RequestBody NotificacionDto notificacion){
        try{
            NotificacionDto res = notificacionService.updateNotificacion(id, notificacion);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDto> getNotificacionById(@PathVariable Long id){
        try{
            NotificacionDto res = notificacionService.findNotificacionByid(id);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<NotificacionDto>> getAllNotificaciones(){
        try{
            List<NotificacionDto> res = notificacionService.findAllNotificaciones();
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotificacion(@PathVariable Long id){
        try {
            notificacionService.deleteNotificacionByid(id);
            return ResponseEntity.ok().body("Cita psicologica eliminada");
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estadoNotificacion")
    public ResponseEntity<List<NotificacionDto>> getNotificacionByEstadoNotificacion(@RequestParam("estadoNotificacion") EstadoNotificacion estadoNotificacion){
        try{
            List<NotificacionDto> res = notificacionService.findNotificacionByEstadoNotificacion(estadoNotificacion);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tipoNotificacion")
    public ResponseEntity<List<NotificacionDto>> getNotificacionByTipoNotificacion(@RequestParam("tipoNotificacion") String tipoNotificacion){
        try{
            List<NotificacionDto> res = notificacionService.findNotificacionByTipoNotificacion(tipoNotificacion);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fechaYHora")
    public ResponseEntity<List<NotificacionDto>> getNotificacionByFechaYHora(@RequestParam("fechaYHora") LocalDateTime fechaYHora){
        try{
            List<NotificacionDto> res = notificacionService.findNotificacionByfechaYHoraDeEnvio(fechaYHora);
            return ResponseEntity.ok().body(res);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
