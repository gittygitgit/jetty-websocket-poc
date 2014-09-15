package examples.echo;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.UpgradeRequest;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import examples.util.Utils;

/**
 * Example EchoSocket using Annotations.
 */
@WebSocket(maxTextMessageSize = 64 * 1024)
public class AnnotatedEchoSocket {

    @OnWebSocketMessage
    public void onText(Session session, String message) {
        if (session.isOpen()) {
            System.out.printf("Echoing back message [%s]%n", message);
            session.getRemote().sendString(message, null);
        }
    }
    
    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.println(Utils.traceMethodEntry("onConnect"));
        UpgradeRequest req = session.getUpgradeRequest();
        String channelName = req.getParameterMap().get("channelName").get(0);
    }
    
    @OnWebSocketClose
    public void onClose(Session session, int close, String closeReason) {
        System.out.println(Utils.traceMethodEntry("onClose"));
    }

}
