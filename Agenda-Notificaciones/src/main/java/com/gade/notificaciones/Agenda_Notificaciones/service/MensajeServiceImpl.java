package com.gade.notificaciones.Agenda_Notificaciones.service;

import com.gade.notificaciones.Agenda_Notificaciones.dto.MensajeDTO;
import com.gade.notificaciones.Agenda_Notificaciones.model.Mensaje;
import com.gade.notificaciones.Agenda_Notificaciones.model.Seccion;
import com.gade.notificaciones.Agenda_Notificaciones.model.Trabajador;
import com.gade.notificaciones.Agenda_Notificaciones.repository.MensajeRepository;
import com.gade.notificaciones.Agenda_Notificaciones.repository.SeccionRepository;
import com.gade.notificaciones.Agenda_Notificaciones.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class MensajeServiceImpl implements MensajeService{
    @Autowired
    private MensajeRepository mensajeRepository;
    @Autowired
    private TrabajadorRepository trabajadorRepository; // <-- Añadir

    @Autowired
    private SeccionRepository seccionRepository;

    @Override
    public List<Mensaje> obtenerMensajesPorSeccion(Long seccionId) {
        return mensajeRepository.findBySeccionId(seccionId);
    }

    @Override
    public Mensaje guardarMensaje(Mensaje mensaje) {

        return mensajeRepository.save(mensaje);
    }

    @Override
    public List<Mensaje> obtenerTodosLosMensajes() {

        return mensajeRepository.findAll();
    }

    @Override
    public Mensaje obtenerMensajePorId(Long id) {
        return mensajeRepository.findById(id).orElse(null);
    }
    //Método para guardar mensajes a partir del nombre, mejor que por id
    @Override
    public Mensaje guardarMensajeDesdeDTO(MensajeDTO dto) {
        // Buscar el trabajador (anotadoPor)
        Trabajador trabajador = trabajadorRepository.findByNombre(dto.getAnotadoPor());
        if (trabajador == null) {
            throw new RuntimeException("Trabajador no encontrado: " + dto.getAnotadoPor());
        }

        // Buscar el destinatario
        Trabajador destinatario = trabajadorRepository.findByNombre(dto.getPara());
        if (destinatario == null) {
            throw new RuntimeException("Destinatario no encontrado: " + dto.getPara());
        }

        // Buscar la sección
        Seccion seccion = seccionRepository.findByNombre(dto.getSeccion());
        if (seccion == null) {
            throw new RuntimeException("Sección no encontrada: " + dto.getSeccion());
        }

        // Parsear la fecha si no está vacía
        LocalDateTime fecha = null;
        if (dto.getFecha() != null && !dto.getFecha().isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            fecha = LocalDateTime.parse(dto.getFecha(), formatter);
        }

        // Crear el mensaje
        Mensaje mensaje = new Mensaje();
        mensaje.setRemitente(dto.getDe());
        mensaje.setDestinatario(destinatario);
        mensaje.setTrabajador(trabajador);
        mensaje.setSeccion(seccion);
        mensaje.setFechaEnvio(fecha);
        mensaje.setContenido(dto.getMotivo());

        return mensajeRepository.save(mensaje);
    }



}
