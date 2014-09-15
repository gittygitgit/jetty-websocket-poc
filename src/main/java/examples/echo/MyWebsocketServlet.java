package examples.echo;

import javax.servlet.annotation.WebServlet;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;


@WebServlet(name = "MyEcho WebSocket Servlet", urlPatterns = { "/echo" })
public class MyWebsocketServlet extends WebSocketServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 3616791300999737243L;

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(10000);
        factory.register(AnnotatedEchoSocket.class);
    }

}
