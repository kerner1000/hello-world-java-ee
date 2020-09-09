package org.example.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/chat")
public class WebsocketEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(WebsocketEndpoint.class);

    private static final Marker sessionMarker = MarkerFactory.getMarker("SESSION");

    private static final Marker messageMarker = MarkerFactory.getMarker("MESSAGE");

    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

    static {
        messageMarker.add(sessionMarker);
    }


    @OnOpen
    public void opened(Session session) {
        logger.trace(sessionMarker, "Openend new session: [{}]", session);
        sessions.add(session);
    }

    @OnClose
    public void closed(Session session) {
        sessions.remove(session);
        logger.trace(sessionMarker, "Session closed: [{}]", session);
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        logger.trace(messageMarker, "Message from session [{}]: [{}]", session, message);
        for (Session client : sessions) {
            client.getAsyncRemote().sendText(message);
        }
    }
}
