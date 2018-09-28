package com.pfl.samples.jee7.websocket;

import javax.websocket.*;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatBot {

    public static void main(String[] args) {
        final ChatClientEndpoint clientEndPoint;
        try {
//            clientEndPoint = new ChatClientEndpoint(new URI("wss://my.tdfort.ru:8897"));

            Endpoint myEnd = new Endpoint() {
                @Override
                public void onOpen(Session session, EndpointConfig endpointConfig) {
                    System.out.println("onOpen");
                }

                @Override
                public void onClose(Session session, CloseReason closeReason) {
                    System.out.println("onClose");
                }

                @Override
                public void onError(Session session, Throwable thr) {
                    System.out.println("onError");
                }

            };


//            try {
                WebSocketContainer container = ContainerProvider.getWebSocketContainer();

                Session session = container.connectToServer(
                        myEnd,
                        buildCEC(),
                        new URI("wss://my.tdfort.ru:8897")
//                        new URI("ws://localhost:8898")
                );








//            throw new RuntimeException(e);


//            clientEndPoint.addMessageHandler(new ChatClientEndpoint.MessageHandler() {
//                public void handleMessage(String message) {
//                    JsonObject jsonObject = Json.createReader(new StringReader(message)).readObject();
//                    String userName = jsonObject.getString("user");
//
//                    if (!"bot".equals(userName)) {
//                        clientEndPoint.sendMessage(getMessage("Hello " + userName +", How are you?"));
//                        // other dirty bot logic goes here.. :)
//                    }
//                }
//            });

//            while (true) {
////                clientEndPoint.sendMessage(getMessage("Hi There!!"));
//                Thread.sleep(30000);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ClientEndpointConfig buildCEC() {
        ClientEndpointConfig config = ClientEndpointConfig.Builder.create().build();
        ClientEndpointConfig.Configurator conf = config.getConfigurator();

        Map<String, List<String>> headers = new HashMap<String, List<String>>();

        headers.put("Connection", Arrays.asList("keep-alive", "Upgrade"));
        headers.put("Sec-Websocket-Extensions", Arrays.asList("x-webkit-deflate-frame"));
        headers.put("Sec-Websocket-key", Arrays.asList("cx36sHrtuW9HZAaB6kKa/Q=="));
        headers.put("Sec-Websocket-Version", Arrays.asList("13"));
        headers.put("Upgrade", Arrays.asList("websocket"));
        headers.put("User-Agent", Arrays.asList("Mozill..."));

        conf.beforeRequest(headers);

        return config;
    }

//    private static String getMessage(String message) {
//        return Json.createObjectBuilder()
//            .add("user", "bot")
//            .add("message", message)
//            .build()
//            .toString();
//    }
 }

//@ClientEndpoint
//class JeK2aEndePoint extends Endpoint {
//
//    @Override
//    public void onOpen(Session session, EndpointConfig endpointConfig) {
//        System.out.println("onOpen");
//    }
//}