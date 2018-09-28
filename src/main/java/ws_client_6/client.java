package ws_client_6;


import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class client {
    public static void main(String[] args) {
        Endpoint myEnd = new Endpoint() {
            @Override
            public void onOpen(Session session, EndpointConfig endpointConfig) {
                System.out.println("onOpen");
            }
        };


        WebSocketContainer container = ContainerProvider.getWebSocketContainer();

        try {
            Session session = (Session) container.connectToServer(
                    myEnd,
                    buildCEC(),
                    new URI("wss://my.tdfort.ru:8897")
            );
        } catch (DeploymentException | URISyntaxException | IOException e) {
            e.printStackTrace();
        }
//


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

}


