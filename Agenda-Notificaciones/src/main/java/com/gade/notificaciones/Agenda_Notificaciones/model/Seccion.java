package com.gade.notificaciones.Agenda_Notificaciones.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "secciones")

public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "seccion")
    private List<Trabajador> trabajadores;

    // Constructor vacío
    public Seccion() {}

    // Constructor con parámetros
    public Seccion(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Trabajador> getTrabajadores() { return trabajadores; }
    public void setTrabajadores(List<Trabajador> trabajadores) { this.trabajadores = trabajadores; }
}
