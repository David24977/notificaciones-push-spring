package com.gade.notificaciones.Agenda_Notificaciones.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String remitente;
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "trabajador_id")
    private Trabajador trabajador;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private Trabajador destinatario;

    @ManyToOne
    @JoinColumn(name = "seccion_id")
    private Seccion seccion;

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio;

    // Constructor vacío
    public Mensaje() {}

    // Constructor con parámetros
    public Mensaje(String remitente, String contenido, Trabajador trabajador, Trabajador destinatario, Seccion seccion, LocalDateTime fechaEnvio) {
        this.remitente = remitente;
        this.contenido = contenido;
        this.trabajador = trabajador;
        this.destinatario = destinatario;
        this.seccion = seccion;
        this.fechaEnvio = fechaEnvio;
    }

    // Getters y Setters
    public Long getId() { return id; }

    public String getRemitente() { return remitente; }
    public void setRemitente(String remitente) { this.remitente = remitente; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public Trabajador getTrabajador() { return trabajador; }
    public void setTrabajador(Trabajador trabajador) { this.trabajador = trabajador; }

    public Seccion getSeccion() { return seccion; }
    public void setSeccion(Seccion seccion) { this.seccion = seccion; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    public Trabajador getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Trabajador destinatario) {
        this.destinatario = destinatario;
    }
}