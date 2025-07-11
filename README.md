# Notificaciones Push con Spring Boot y Firebase

Este proyecto es una API REST construida con Spring Boot que permite el envío de notificaciones push a dispositivos Android mediante Firebase Cloud Messaging (FCM).

---

## Funcionalidades

- Envío de notificaciones push desde el backend
- Integración con Firebase
- Gestión básica de errores
- Base para apps móviles con backend personalizado

---

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Maven
- Firebase Admin SDK
- MySQL (opcional)
- IntelliJ IDEA

---

## Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/David24977/notificaciones-push-spring.git
   ```

  ___

2.	Abre el proyecto en IntelliJ IDEA (u otro IDE compatible)
3.	Coloca tu archivo firebase-config.json en la carpeta:


  	src/main/resources/

4.	Ejecuta la clase principal del proyecto:


    NotificacionesPushApplication.java


Nota sobre Firebase

Este proyecto requiere una cuenta en Firebase y un archivo de configuración con credenciales (firebase-config.json).

Pasos para obtenerlo:
	•	Accede a https://console.firebase.google.com
	•	En tu proyecto, ve a Project Settings > Service accounts
	•	Descarga el archivo JSON correspondiente

Importante: No subas este archivo al repositorio. Ya está incluido en .gitignore.



Autor

David Ferrer Sapiña
Técnico Informático
Correo: davidferrersapinya@gmail.com
Ubicación: España



Licencia

Este proyecto está bajo la licencia MIT. Puede ser utilizado libremente con fines educativos y profesionales.



  ___
    

   
