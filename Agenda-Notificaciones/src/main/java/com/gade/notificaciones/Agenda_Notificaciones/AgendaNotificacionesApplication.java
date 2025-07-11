package com.gade.notificaciones.Agenda_Notificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.gade.notificaciones.Agenda_Notificaciones")
public class AgendaNotificacionesApplication {

	public static void main(String[] args) {

		SpringApplication.run(AgendaNotificacionesApplication.class, args);
	}

}
