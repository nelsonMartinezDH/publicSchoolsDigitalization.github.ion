package com.web.colegiofdps.services.notificacion;

import com.web.colegiofdps.Entities.EstadoNotificacion;
import com.web.colegiofdps.Entities.PadreDeFamilia;
import com.web.colegiofdps.dtos.Notificacion.NotificacionDto;
import com.web.colegiofdps.dtos.Notificacion.NotificacionToSaveDto;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificacionService {
    NotificacionDto saveNotificacion(NotificacionDto notificacion);
    NotificacionDto updateNotificacion(Long id, NotificacionDto notificacion);
    NotificacionDto findNotificacionByid(Long id);
    List<NotificacionDto> findAllNotificaciones();
    void deleteNotificacionByid(Long id);
    NotificacionDto findNotificacionByPadreDeFamilia(PadreDeFamilia padreDeFamilia);
    List<NotificacionDto> findNotificacionByEstadoNotificacion(EstadoNotificacion estadoNotificacion);
    List<NotificacionDto> findNotificacionByTipoNotificacion(String tipoNotificacion);
    List<NotificacionDto> findNotificacionByfechaYHoraDeEnvio(LocalDateTime fechaYHoraDeEnvio);
}
