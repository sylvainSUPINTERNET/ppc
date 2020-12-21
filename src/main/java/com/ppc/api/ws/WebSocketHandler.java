package com.ppc.api.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import java.io.IOException;

import com.ppc.api.services.VisitorEntityService;
import com.ppc.api.staticCnf.PathingActions;
import com.ppc.api.staticCnf.WsDispatchActions;
import com.ppc.api.services.WsMessageDispatcherVisitor;
import com.ppc.api.services.WsMessageDispatcherPathing;

@Component
public class WebSocketHandler extends AbstractWebSocketHandler {
    private Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    WsDispatchActions wsDispatchActions;
    
    VisitorEntityService visitorEntityService;

    WebSocketHandler(VisitorEntityService visitorEntityService, WsDispatchActions wsDispatchActions) {
        this.visitorEntityService = visitorEntityService;
        this.wsDispatchActions = wsDispatchActions;
    }

    
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        if ( session.isOpen() ) {
            System.out.println("ETABLISHED SESSION : " + session.getId());
        }
    }
    
    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("CALLED CONNECTION CLOSED");
        System.out.println(session.getId());



	}

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {

        String actionReceived = wsDispatchActions.getActionFromClient(message.getPayload());
        Object dataReceived = wsDispatchActions.getDataFromClient(message.getPayload());
        this.logger.info("ACTION : {}", actionReceived);
        wsDispatchActions.doAction(actionReceived, dataReceived, session);
        
        
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
