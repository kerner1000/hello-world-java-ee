package org.example.javaee.helloworld.websocket.client;


import javax.websocket.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;

@javax.websocket.ClientEndpoint
public class ClientEndpoint {

    public static interface MessageHandler {
        void handleMessage(String message);
    }

    private MessageHandler messageHandler;
    private Session userSession;

    ClientEndpoint(URI endpointURI){

        WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
        try {
            webSocketContainer.connectToServer(this, endpointURI);
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void onOpen(Session userSession) {
        this.userSession = userSession;
    }

    @OnClose
    public void onClose(Session userSession, CloseReason closeReason) {
        this.userSession = null;
    }

    @OnMessage
    public void onMessage(String message) {
        if (messageHandler != null) {
            messageHandler.handleMessage(message);
        }
    }

    public void addMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public void sendMessage(String message) {
        userSession.getAsyncRemote().sendText(message);
    }
}
