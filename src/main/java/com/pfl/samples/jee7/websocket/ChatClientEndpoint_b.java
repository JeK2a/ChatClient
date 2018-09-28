package com.pfl.samples.jee7.websocket;

import javax.websocket.*;
import java.io.IOException;

@ClientEndpoint
public class ChatClientEndpoint_b {
    Session session = null;
//    private MessageHandler messageHandler;

    public ChatClientEndpoint_b() {
        System.out.println("__constructor");
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;

        System.out.println("Session");

        try {
            System.out.println("Session");
//            this.session.getBasicRemote().sendText("Session ID: " + this.session.getId());
            this.session.getBasicRemote().sendText("{\"act\":\"start\", \"msg\":\"Connection open with . Подключение установлено обоюдно, отлично!\"}");
        } catch (Exception ex) {
            ex.printStackTrace();
//            throw new RuntimeException(ex);
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.session = null;
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println(message);
//        if (this.messageHandler != null) {
//            this.messageHandler.handleMessage(message);
//        }
    }

//    public void addMessageHandler(MessageHandler msgHandler) {
//        this.messageHandler = msgHandler;
//    }
//
    public void sendMessage(String message) {
        this.session.getAsyncRemote().sendText(message);
    }
//
//    public static interface MessageHandler {
//        public void handleMessage(String message);
//    }
}