package com.gade.notificaciones.Agenda_Notificaciones.service;

import com.gade.notificaciones.Agenda_Notificaciones.dto.MensajeDTO;
import com.gade.notificaciones.Agenda_Notificaciones.model.Mensaje;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MensajeService {
    List<Mensaje> obtenerMensajesPorSeccion(Long SeccionId);
    Mensaje guardarMensaje(Mensaje mensaje);

    Mensaje guardarMensajeDesdeDTO(MensajeDTO dto);

    List<Mensaje> obtenerTodosLosMensajes();

    Mensaje obtenerMensajePorId(Long id);
}
