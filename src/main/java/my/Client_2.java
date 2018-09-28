package my;

import org.glassfish.tyrus.core.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.net.URI;

public class Client_2 {
    public static void main(String[] args) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();

            container.connectToServer(
                    new WeatherClient(),
                    new URI("wss://my.tdfort.ru:8897")
            );

//            container.connectToServer(
//                    WeatherClient.class,
//                    ClientEndpointConfig.Builder.create().build(),
//                    URI.create("wss://my.tdfort.ru:8897")
//            );
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
