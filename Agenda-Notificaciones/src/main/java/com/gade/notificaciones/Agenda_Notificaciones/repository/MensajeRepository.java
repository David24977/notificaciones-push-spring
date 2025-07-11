package com.gade.notificaciones.Agenda_Notificaciones.repository;
import com.gade.notificaciones.Agenda_Notificaciones.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MensajeRepository extends JpaRepository<Mensaje, Long>{
    List<Mensaje> findBySeccionId(Long seccionId); // Buscar mensajes por sección

}
