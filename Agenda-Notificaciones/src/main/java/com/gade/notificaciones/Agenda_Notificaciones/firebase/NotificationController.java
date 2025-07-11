package com.gade.notificaciones.Agenda_Notificaciones.firebase;

import com.gade.notificaciones.Agenda_Notificaciones.FirebaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    private final FirebaseService firebaseService;

    // Corregido el nombre del constructor
    public NotificationController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @PostMapping
    public ResponseEntity<String> enviarNotificacion(@RequestParam String token, @RequestParam String titulo, @RequestParam String cuerpo) {
        try {
            // Usar el servicio FirebaseService para enviar la notificación
            firebaseService.enviarNotificacion(token, titulo, cuerpo);
            return ResponseEntity.ok("Notificación enviada con éxito");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al enviar la notificación: " + e.getMessage());
        }
    }
}