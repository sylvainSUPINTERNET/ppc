package com.ppc.api.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppc.api.dto.metric.MetricReceivedDto;
import com.ppc.api.services.VisitorEntityService;


@Component
public class WebSocketHandler extends AbstractWebSocketHandler {

    
    VisitorEntityService visitorEntityService;

    WebSocketHandler(VisitorEntityService visitorEntityService) {
        this.visitorEntityService = visitorEntityService;
    }

    private Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        logger.info("TEST message WS : {}", message.getPayload());    
        String msg = message.getPayload();
            ObjectMapper objectMapper = new ObjectMapper();
            MetricReceivedDto metricReceivedDto = objectMapper.readValue(msg, MetricReceivedDto.class);
            this.visitorEntityService.createVisitorEntity(metricReceivedDto);
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
            System.out.println("New Binary Message Received");
            session.sendMessage(message);
    }



}
