package com.gade.notificaciones.Agenda_Notificaciones.dto;

public class MensajeDTO {
    private String de;
    private String para;
    private String seccion;
    private String anotadoPor;
    private String fecha;
    private String motivo;

    public MensajeDTO(String de, String para, String seccion, String anotadoPor, String fecha, String motivo) {
        this.de = de;
        this.para = para;
        this.seccion = seccion;
        this.anotadoPor = anotadoPor;
        this.fecha = fecha;
        this.motivo = motivo;
    }

    // Getters y Setters
    public String getDe() { return de; }
    public void setDe(String de) { this.de = de; }

    public String getPara() { return para; }
    public void setPara(String para) { this.para = para; }

    public String getSeccion() { return seccion; }
    public void setSeccion(String seccion) { this.seccion = seccion; }

    public String getAnotadoPor() { return anotadoPor; }
    public void setAnotadoPor(String anotadoPor) { this.anotadoPor = anotadoPor; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}
