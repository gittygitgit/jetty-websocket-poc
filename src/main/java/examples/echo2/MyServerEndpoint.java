package examples.echo2;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import examples.util.Utils;

@ServerEndpoint("/notifications/{badge}")
public class MyServerEndpoint {

    private static SubscriberRegistry subscribers = new SubscriberRegistry();
    
    /**
     * Invoked after connection is established
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("badge") String badge) {
        subscribers.add(badge, session);
        System.out.println(Utils.traceMethodEntry("onOpen"));
        System.out.println("badge=" + badge);
        
    }
    
    @OnError
    public void onError(Throwable t, Session session, @PathParam("badge") String badge) {
        System.out.println(Utils.traceMethodEntry("onError"));
        t.printStackTrace();
    }
    
    @OnClose
    public void onClose(Session session, CloseReason closeReason, @PathParam("badge") String badge) {
        System.out.println(Utils.traceMethodEntry("onClose"));
    }
    

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("badge") String badge) {
        System.out.println(Utils.traceMethodEntry("onMessage"));
    }
    
}
