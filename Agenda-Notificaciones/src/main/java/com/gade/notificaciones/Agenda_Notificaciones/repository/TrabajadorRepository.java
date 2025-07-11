package com.gade.notificaciones.Agenda_Notificaciones.repository;

import com.gade.notificaciones.Agenda_Notificaciones.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    List<Trabajador> findBySeccion_Id(Long seccionId); // Buscar trabajadores por sección

    List<Trabajador> findBySeccion_Nombre(String nombreSeccion);
    Trabajador findByNombre(String nombre);
}
