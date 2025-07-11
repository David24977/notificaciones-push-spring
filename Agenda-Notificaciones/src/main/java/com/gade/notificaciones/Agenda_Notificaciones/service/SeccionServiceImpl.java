package com.gade.notificaciones.Agenda_Notificaciones.service;

import com.gade.notificaciones.Agenda_Notificaciones.model.Seccion;
import com.gade.notificaciones.Agenda_Notificaciones.repository.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeccionServiceImpl implements SeccionService{
    @Autowired
    private SeccionRepository seccionRepository;

    @Override
    public List<Seccion> obtenerTodasLasSecciones() {
        return seccionRepository.findAll();
    }

    @Override
    public Seccion obtenerSeccionPorId(Long id) {
        Optional<Seccion> seccion = seccionRepository.findById(id);
        return seccion.orElse(null);
    }

    @Override
    public Seccion guardarSeccion(Seccion seccion) {
        return seccionRepository.save(seccion);
    }
}

