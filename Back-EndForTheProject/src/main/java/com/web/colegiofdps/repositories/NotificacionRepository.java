package com.web.colegiofdps.repositories;

import com.web.colegiofdps.Entities.EstadoNotificacion;
import com.web.colegiofdps.Entities.Notificacion;
import com.web.colegiofdps.Entities.PadreDeFamilia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    @Override
    Optional<Notificacion> findById(Long aLong);

    Optional<Notificacion> findNotificacionByContenidoNotificacion(String contenidoNotificacion);

    @Override
    List<Notificacion> findAll();

    List<Notificacion> findNotificacionsByPadreDeFamilia(PadreDeFamilia padreDeFamilia);

    List<Notificacion> findNotificacionsByEstadoNotificacion(EstadoNotificacion estadoNotificacion);

    List<Notificacion> findNotificacionsByTipoNotificacion(String tipoNotificacion);

    List<Notificacion> findNotificacionsByFechaYHoraDeEnvio(LocalDateTime fechaYHoraDeEnvio);
}
