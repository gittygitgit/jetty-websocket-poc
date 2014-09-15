package examples.echo2;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

public class SubscriberRegistry {

    private Map<String, Session> subscribers = new HashMap<String, Session>();
    
    public void add(String badge, Session session) {
        this.subscribers.put(badge, session);
    }
    
    public boolean isSubscribed(String badge) {
        return this.subscribers.containsKey(badge);
    }
}
