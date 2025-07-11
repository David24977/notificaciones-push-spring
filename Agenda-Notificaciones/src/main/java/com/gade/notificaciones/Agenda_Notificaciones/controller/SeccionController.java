package com.gade.notificaciones.Agenda_Notificaciones.controller;

import com.gade.notificaciones.Agenda_Notificaciones.model.Seccion;
import com.gade.notificaciones.Agenda_Notificaciones.service.SeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/secciones")

public class SeccionController {
    @Autowired
    private SeccionService seccionService;

    // Obtener todas las secciones
    @GetMapping
    public List<Seccion> obtenerTodasLasSecciones() {
        return seccionService.obtenerTodasLasSecciones();
    }

    // Obtener una sección por ID
    @GetMapping("/{id}")
    public Seccion obtenerSeccionPorId(@PathVariable Long id) {
        return seccionService.obtenerSeccionPorId(id);
    }

    // Guardar una nueva sección
    @PostMapping
    public Seccion guardarSeccion(@RequestBody Seccion seccion) {
        return seccionService.guardarSeccion(seccion);
    }
}
