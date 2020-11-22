package com.ppc.api.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.json.JSONObject;
import java.io.IOException;

@Component
public class WebSocketHandler extends AbstractWebSocketHandler {

    private Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
            String msg = message.getPayload();
            JSONObject metric = new JSONObject(msg);
            System.out.println(metric.get("county"));
            // CREATE DTO qui va ressembler à ca ;
            //
            //session.sendMessage(message);
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
            System.out.println("New Binary Message Received");
            session.sendMessage(message);
    }



}
