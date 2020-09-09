package org.example.javaee.helloworld.websocket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

public class ConsoleClient {

    public static void main(String[] args) throws URISyntaxException, IOException {

        ClientEndpoint client = new ClientEndpoint(new URI("ws://localhost:8144/helloworld/chat"));

        client.addMessageHandler(message ->   System.out.println("==> " + message));

        while(true){

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String newMessage = bufferedReader.readLine();

            if(newMessage.equals("---")){
                break;
            }

            client.sendMessage(newMessage);
        }

    }
}
