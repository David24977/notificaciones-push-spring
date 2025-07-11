package com.gade.notificaciones.Agenda_Notificaciones.service;

import com.gade.notificaciones.Agenda_Notificaciones.model.Seccion;

import java.util.List;

public interface SeccionService {
    List<Seccion> obtenerTodasLasSecciones();
    Seccion obtenerSeccionPorId(Long id);
    Seccion guardarSeccion(Seccion seccion);
}
