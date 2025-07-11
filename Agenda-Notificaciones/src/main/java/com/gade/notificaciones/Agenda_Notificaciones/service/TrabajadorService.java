package com.gade.notificaciones.Agenda_Notificaciones.service;

import com.gade.notificaciones.Agenda_Notificaciones.model.Trabajador;

import java.util.List;

public interface TrabajadorService {
    List<Trabajador> obtenerTrabajadorPorSeccion(String nombreSeccion);
    Trabajador guardarTrabajador(Trabajador trabajador);
}
