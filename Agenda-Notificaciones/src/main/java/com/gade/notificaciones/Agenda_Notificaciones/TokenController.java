package com.gade.notificaciones.Agenda_Notificaciones;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tokens")

public class TokenController {
    @PostMapping
    public ResponseEntity<String> registrarToken(@RequestBody TokenRequest tokenRequest) {
        System.out.println("Token recibido: " + tokenRequest.getToken());
        System.out.println("Sección: " + tokenRequest.getSeccion());

        // Aquí podrías guardar el token en base de datos si quieres

        return ResponseEntity.ok("Token registrado correctamente");
    }

}
