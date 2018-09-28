package my;


import javax.websocket.*;
import java.io.IOException;

@ClientEndpoint
//public class WeatherClient extends Endpoint {
public class WeatherClient  {
    private Session session;
    private MessageHandler messageHandler;

//    @Override
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        try {
            System.out.println("Session");
            this.session.getBasicRemote().sendText("Session ID: " + this.session.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
//            throw new RuntimeException(ex);
        }
    }

    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        this.session = null;
    }

    @OnMessage
    public void onMessage(String message) {
//        if (this.messageHandler != null) {
//            this.messageHandler.handleMessage(message);
//        }
    }

//    public void addMessageHandler(MessageHandler msgHandler) {
//        this.messageHandler = msgHandler;
//    }
//
//    public void sendMessage(String message) {
//        this.session.getAsyncRemote().sendText(message);
//    }
//
//    public static interface MessageHandler {
//        public void handleMessage(String message);
//    }

}
