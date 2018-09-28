//package server;
//
//
//import io.undertow.Undertow;
//import io.undertow.server.HttpHandler;
//import io.undertow.server.HttpServerExchange;
//import io.undertow.util.Headers;
//
//
//
//public class s1 {
//    public static void main(String[] args) {
////        Undertow server = Undertow.builder()
////                .addHttpListener(8080, "localhost")
////                .setHandler(path()
////                        .addPrefixPath("/myapp", websocket(new WebSocketConnectionCallback() {
////
////                            @Override
////                            public void onConnect(WebSocketHttpExchange exchange, WebSocketChannel channel) {
////                                channel.getReceiveSetter().set(new AbstractReceiveListener() {
////
////                                    @Override
////                                    protected void onFullTextMessage(WebSocketChannel channel, BufferedTextMessage message) {
////                                        final String messageData = message.getData();
////                                        for (WebSocketChannel session : channel.getPeerConnections()) {
////                                            WebSockets.sendText(messageData, session, null);
////                                        }
////                                    }
////                                });
////                                channel.resumeReceives();
////                            }
////                        }))
////                        .build();
////
////        server.start();
//
//
//        Undertow server = Undertow.builder()
//                .addHttpListener(8898, "localhost")
//                .setHandler(new HttpHandler() {
//                    @Override
//                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
//                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
//                        exchange.getResponseSender().send("Hello World");
//                    }
//                }).build();
//        server.start();
//    }
//}
