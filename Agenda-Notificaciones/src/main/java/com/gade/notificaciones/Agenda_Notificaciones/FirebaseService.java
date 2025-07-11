package com.gade.notificaciones.Agenda_Notificaciones;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;

@Service
public class FirebaseService {

    @PostConstruct
    public void init() {
        try {
            // Cargar el archivo firebaseConfig.json desde el classpath
            InputStream serviceAccount = getClass().getClassLoader()
                    .getResourceAsStream("firebase/firebaseConfig.json");

            if (serviceAccount == null) {
                throw new IllegalStateException("❌ No se encontró el archivo firebaseConfig.json en el classpath.");
            }

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            // Inicializar Firebase si no está ya inicializado
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("✅ Firebase inicializado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Error al inicializar Firebase: " + e.getMessage());
        }
    }

    public void enviarNotificacion(String token, String title, String body) {
        try {
            //Per a que es vega notificació en 2on pla o tancà
            Notification notification = Notification.builder()
                    .setTitle(title)
                    .setBody(body)
                    .build();
            //Fiquem data per a recibir sempre
            Message message = Message.builder()
                    .setToken(token)
                    //.setNotification(notification)
                    .putData("title", title) // redundancia para asegurar recepción
                    .putData("body", body)
                    .build();

            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("✅ Notificación enviada con ID: " + response);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Error al enviar la notificación: " + e.getMessage());
        }
    }
}