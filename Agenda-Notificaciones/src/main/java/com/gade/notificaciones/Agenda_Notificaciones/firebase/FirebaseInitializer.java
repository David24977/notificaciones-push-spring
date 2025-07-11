package com.gade.notificaciones.Agenda_Notificaciones.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.io.IOException;

@Component
public class FirebaseInitializer {

    @PostConstruct
    public void initialize() {
        try {
            // Carga el archivo JSON desde el directorio classpath
            InputStream serviceAccount = new ClassPathResource("firebase/firebaseConfig.json").getInputStream();

            // Configura las opciones de Firebase utilizando las credenciales de la cuenta de servicio
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            // Inicializa Firebase solo si no se ha inicializado previamente
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("✅ Firebase inicializado correctamente.");
            } else {
                System.out.println("⚠️ Firebase ya estaba inicializado.");
            }
        } catch (IOException e) {
            // Si hay un error con el archivo JSON o la inicialización, se imprimirá el error
            System.out.println("❌ Error al cargar el archivo de configuración de Firebase.");
            e.printStackTrace();
        } catch (Exception e) {
            // Captura cualquier otro error que pueda ocurrir
            System.out.println("❌ Error al inicializar Firebase.");
            e.printStackTrace();
        }
    }
}
