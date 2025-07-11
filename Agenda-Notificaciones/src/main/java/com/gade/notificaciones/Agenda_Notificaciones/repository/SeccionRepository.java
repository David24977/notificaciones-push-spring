package com.gade.notificaciones.Agenda_Notificaciones.repository;

import com.gade.notificaciones.Agenda_Notificaciones.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeccionRepository extends JpaRepository<Seccion, Long> {
    Seccion findByNombre(String nombre);
}
