package com.web.colegiofdps.services.notificacion;

import com.web.colegiofdps.Entities.EstadoNotificacion;
import com.web.colegiofdps.Entities.Notificacion;
import com.web.colegiofdps.Entities.PadreDeFamilia;
import com.web.colegiofdps.dtos.Notificacion.NotificacionDto;
import com.web.colegiofdps.exceptions.NotFoundException;
import com.web.colegiofdps.mappers.NotificacionMapper;
import com.web.colegiofdps.repositories.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacionServiceImpl implements NotificacionService{

    private final NotificacionRepository notificacionRepository;

    private final NotificacionMapper notificacionMapper;

    @Autowired
    public NotificacionServiceImpl(NotificacionRepository notificacionRepository,
                                   NotificacionMapper notificacionMapper) {
        this.notificacionRepository = notificacionRepository;
        this.notificacionMapper = notificacionMapper;
    }

    @Override
    public NotificacionDto saveNotificacion(NotificacionDto notificacion) {
        Notificacion notificacionToSave = notificacionMapper.notificacionDtoToNotificacionEntity(notificacion);
        Notificacion notificacionSaved = notificacionRepository.save(notificacionToSave);
        return notificacionMapper.notificacionEntityToNotificacionDto(notificacionSaved);
    }

    @Override
    public NotificacionDto updateNotificacion(Long id, NotificacionDto notificacion) {
        Optional<Notificacion> notificacionConsulted = notificacionRepository.findById(id);

        if (notificacionConsulted.isEmpty()) throw new NotFoundException("La notificacion con ID " + id + " no fue encontrada");

        Notificacion n = notificacionConsulted.get();

        if (notificacion.tipoNotificacion() != null) n.setTipoNotificacion(notificacion.tipoNotificacion());
        if (notificacion.contenidoNotificacion() != null) n.setContenidoNotificacion(notificacion.contenidoNotificacion());
        if (notificacion.fechaYHoraDeEnvio() != null) n.setFechaYHoraDeEnvio(notificacion.fechaYHoraDeEnvio());
        if (notificacion.estadoNotificacion() != null) n.setEstadoNotificacion(notificacion.estadoNotificacion());

        Notificacion updatedNotificacion = notificacionRepository.save(n);
        return notificacionMapper.notificacionEntityToNotificacionDto(updatedNotificacion);
    }

    @Override
    public NotificacionDto findNotificacionByid(Long id) {
        Optional<Notificacion> notificacion = notificacionRepository.findById(id);
        if (notificacion.isEmpty()) throw new NotFoundException("La notificacion con ID " + id + " no fue encontrada");
        return notificacionMapper.notificacionEntityToNotificacionDto(notificacion.get());
    }

    @Override
    public List<NotificacionDto> findAllNotificaciones() {
        List<Notificacion> notificacions = notificacionRepository.findAll();

        if (notificacions.isEmpty()) throw new NotFoundException("Ninguna notificacion fue encontrada");

        List<NotificacionDto> allNotificacions = new ArrayList<>();

        notificacions.forEach( notificacion -> {
            NotificacionDto n = notificacionMapper.notificacionEntityToNotificacionDto(notificacion);
            allNotificacions.add(n);
        } );

        return allNotificacions;
    }

    @Override
    public void deleteNotificacionByid(Long id) {
        Optional<Notificacion> foundNotification = notificacionRepository.findById(id);
        if (foundNotification.isEmpty()) throw new NotFoundException("La notificacion con ID " + id + " no fue encontrada");
        notificacionRepository.deleteById(id);
    }

    @Override
    public NotificacionDto findNotificacionByPadreDeFamilia(PadreDeFamilia padreDeFamilia) {
        return null;
    }

    @Override
    public List<NotificacionDto> findNotificacionByEstadoNotificacion(EstadoNotificacion estadoNotificacion) {
        List<Notificacion> notificacions = notificacionRepository.findNotificacionsByEstadoNotificacion(estadoNotificacion);

        if (notificacions.isEmpty()) throw new NotFoundException("Ninguna notificacion fue encontrada");

        List<NotificacionDto> foundNotificacions = new ArrayList<>();

        notificacions.forEach( notificacion -> {
            NotificacionDto n = notificacionMapper.notificacionEntityToNotificacionDto(notificacion);
            foundNotificacions.add(n);
        } );

        return foundNotificacions;
    }

    @Override
    public List<NotificacionDto> findNotificacionByTipoNotificacion(String tipoNotificacion) {
        List<Notificacion> notificacions = notificacionRepository.findNotificacionsByTipoNotificacion(tipoNotificacion);

        if (notificacions.isEmpty()) throw new NotFoundException("Ninguna notificacion fue encontrada");

        List<NotificacionDto> foundNotificacions = new ArrayList<>();

        notificacions.forEach( notificacion -> {
            NotificacionDto n = notificacionMapper.notificacionEntityToNotificacionDto(notificacion);
            foundNotificacions.add(n);
        } );

        return foundNotificacions;
    }

    @Override
    public List<NotificacionDto> findNotificacionByfechaYHoraDeEnvio(LocalDateTime fechaYHoraDeEnvio) {
        List<Notificacion> notificacions = notificacionRepository.findNotificacionsByFechaYHoraDeEnvio(fechaYHoraDeEnvio);

        if (notificacions.isEmpty()) throw new NotFoundException("Ninguna notificacion fue encontrada");

        List<NotificacionDto> foundNotificacions = new ArrayList<>();

        notificacions.forEach( notificacion -> {
            NotificacionDto n = notificacionMapper.notificacionEntityToNotificacionDto(notificacion);
            foundNotificacions.add(n);
        } );

        return foundNotificacions;
    }
}
