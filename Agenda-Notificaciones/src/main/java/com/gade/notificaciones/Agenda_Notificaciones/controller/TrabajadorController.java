package com.gade.notificaciones.Agenda_Notificaciones.controller;

import com.gade.notificaciones.Agenda_Notificaciones.model.Trabajador;
import com.gade.notificaciones.Agenda_Notificaciones.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {
    @Autowired
    private TrabajadorService trabajadorService;

    // Obtener trabajadores por sección
    @GetMapping("/seccion/{nombreSeccion}")
    public List<Trabajador> obtenerTrabajadoresPorSeccion(@PathVariable String nombreSeccion) {
        return trabajadorService.obtenerTrabajadorPorSeccion(nombreSeccion);
    }

    // Guardar un trabajador
    @PostMapping
    public Trabajador guardarTrabajador(@RequestBody Trabajador trabajador) {
        return trabajadorService.guardarTrabajador(trabajador);
    }
}

