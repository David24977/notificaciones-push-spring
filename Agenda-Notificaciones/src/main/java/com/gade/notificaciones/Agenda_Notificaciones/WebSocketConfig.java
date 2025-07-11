package com.gade.notificaciones.Agenda_Notificaciones;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer{
//    @Bean
//    public MyWebSocketHandler myWebSocketHandler() {
//        return new MyWebSocketHandler();
//    }
//
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        System.out.println("Registrando WebSocket");
//        registry.addHandler(new MyWebSocketHandler(), "/ws").setAllowedOrigins("*");
//    }
//}
//
//class MyWebSocketHandler extends TextWebSocketHandler {
//    @Override
//    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        System.out.println("Mensaje recibido: " + message.getPayload());
//        session.sendMessage(new TextMessage("Echo: " + message.getPayload()));
//    }
//}

