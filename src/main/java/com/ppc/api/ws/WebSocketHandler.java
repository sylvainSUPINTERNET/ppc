package com.ppc.api.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import java.io.IOException;

import com.ppc.api.services.VisitorEntityService;
import com.ppc.api.staticCnf.PathingActions;
import com.ppc.api.staticCnf.WsDispatchActions;

@Component
public class WebSocketHandler extends AbstractWebSocketHandler {

    @Autowired
    WsDispatchActions WsDispatchActions;

    VisitorEntityService visitorEntityService;

    WebSocketHandler(VisitorEntityService visitorEntityService) {
        this.visitorEntityService = visitorEntityService;
    }

    private Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println(WsDispatchActions.getActionFromClient(message.getPayload()));
        System.out.println(PathingActions.CREATE_PATHING.toString());
        // TODO ici une règle pour récuperer certains message et faire certainne actions en conséqueunce 
        // ENUMERATION POUR CA et il faut faire matcher ça côté front

        /*
        logger.info("TEST message WS : {}", message.getPayload());    
        String msg = message.getPayload();
        ObjectMapper objectMapper = new ObjectMapper();
        MetricReceivedDto metricReceivedDto = objectMapper.readValue(msg, MetricReceivedDto.class);
        this.visitorEntityService.createVisitorEntity(metricReceivedDto);*/
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
            System.out.println("New Binary Message Received");
            session.sendMessage(message);
    }



}
