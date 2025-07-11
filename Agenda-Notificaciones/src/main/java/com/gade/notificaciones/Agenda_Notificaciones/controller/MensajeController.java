package com.gade.notificaciones.Agenda_Notificaciones.controller;

import com.gade.notificaciones.Agenda_Notificaciones.dto.MensajeDTO;
import com.gade.notificaciones.Agenda_Notificaciones.model.Mensaje;
import com.gade.notificaciones.Agenda_Notificaciones.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.format.DateTimeFormatter;




@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @GetMapping
    public List<Mensaje> obtenerTodosLosMensajes() {
        return mensajeService.obtenerTodosLosMensajes();
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardarMensaje(@RequestBody MensajeDTO mensajeDTO) {
        try {
            mensajeService.guardarMensajeDesdeDTO(mensajeDTO);
            return ResponseEntity.ok("Mensaje guardado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error al guardar el mensaje: " + e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Mensaje obtenerMensajePorId(@PathVariable Long id) {
        return mensajeService.obtenerMensajePorId(id);
    }

    @PostMapping
    public Mensaje guardarMensaje(@RequestBody Mensaje mensaje) {
        return mensajeService.guardarMensaje(mensaje);
    }

    @GetMapping("/seccion/{seccionId}")
    public List<Mensaje> obtenerMensajesPorSeccion(@PathVariable Long seccionId) {
        return mensajeService.obtenerMensajesPorSeccion(seccionId);
    }

    @GetMapping("/formateados")
    public List<MensajeDTO> obtenerMensajesDTO() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return mensajeService.obtenerTodosLosMensajes().stream()
                .map(mensaje -> new MensajeDTO(
                        mensaje.getRemitente(),
                        mensaje.getDestinatario() != null ? mensaje.getDestinatario().getNombre() : "Desconocido",
                        mensaje.getSeccion() != null ? mensaje.getSeccion().getNombre() : "Sin sección",
                        mensaje.getTrabajador() != null ? mensaje.getTrabajador().getNombre() : "Desconocido",
                        mensaje.getFechaEnvio() != null ? mensaje.getFechaEnvio().format(formatter) : "",
                        mensaje.getContenido()
                )).toList();
    }
}
