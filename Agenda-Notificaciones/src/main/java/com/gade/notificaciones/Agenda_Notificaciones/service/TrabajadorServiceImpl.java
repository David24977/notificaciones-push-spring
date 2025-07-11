package com.gade.notificaciones.Agenda_Notificaciones.service;


import com.gade.notificaciones.Agenda_Notificaciones.model.Trabajador;
import com.gade.notificaciones.Agenda_Notificaciones.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {
    @Autowired


    private final TrabajadorRepository trabajadorRepository;

    // Inyección de dependencia del repositorio usando @Autowired
    @Autowired
    public TrabajadorServiceImpl(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    @Override
    public List<Trabajador> obtenerTrabajadorPorSeccion(String nombreSeccion) {
        return trabajadorRepository.findBySeccion_Nombre(nombreSeccion);
    }

    @Override
    public Trabajador guardarTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }
}



