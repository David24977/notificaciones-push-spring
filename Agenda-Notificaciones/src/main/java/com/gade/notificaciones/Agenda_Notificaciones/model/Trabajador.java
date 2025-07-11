package com.gade.notificaciones.Agenda_Notificaciones.model;
import jakarta.persistence.*;

@Entity
@Table(name = "trabajadores")

public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "seccion_id")
    private Seccion seccion;

    // Constructor vacío
    public Trabajador() {}

    // Constructor con parámetros
    public Trabajador(String nombre, Seccion seccion) {
        this.nombre = nombre;
        this.seccion = seccion;
    }

    // Getters y Setters
    public Long getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Seccion getSeccion() { return seccion; }
    public void setSeccion(Seccion seccion) { this.seccion = seccion; }
}

