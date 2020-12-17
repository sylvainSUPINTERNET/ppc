package com.ppc.api.staticCnf;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppc.api.dto.metric.MetricReceivedDto;
import com.ppc.api.services.WsMessageDispatcherVisitor;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Actions for WS message received, allow for filter and apply the corresponding
 * actions
 */
@Service
public class WsDispatchActions {
    private Logger logger = LoggerFactory.getLogger(WsDispatchActions.class);

    VisitorActions visitorActions;
    PathingActions pathingActions;
    WsMessageDispatcherVisitor wsMessageDispatcherVisitor;

    WsDispatchActions(VisitorActions visitorActions, PathingActions pathingActions,
            WsMessageDispatcherVisitor wsMessageDispatcherVisitor) {
        this.visitorActions = visitorActions;
        this.pathingActions = pathingActions;
        this.wsMessageDispatcherVisitor = wsMessageDispatcherVisitor;
    }

    public String getActionFromClient(String wsPayload) {
        String msg = wsPayload;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MetricReceivedDto metricReceivedDto = objectMapper.readValue(msg, MetricReceivedDto.class);
            return metricReceivedDto.getAction();
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    public Object getDataFromClient(String wsPayload) {
        String msg = wsPayload;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MetricReceivedDto metricReceivedDto = objectMapper.readValue(msg, MetricReceivedDto.class);
            return metricReceivedDto.getData();
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    public String doAction(String action, Object data, WebSocketSession session) throws IOException {
        this.logger.info("ACTION : {} " , action);
        this.logger.info("DATA : {} ", data);

        switch ( action ) {
            case VisitorActions.CREATE_VISITOR:
                this.logger.info("Call CREATE VISITOR service");
                this.wsMessageDispatcherVisitor.createVisitor(action, data, session);
            break;
            case PathingActions.CREATE_PATHING:
                this.logger.info("Call CREATE PATHING service");
            break;
            default:
                this.logger.info("No valid action send.");
            // NO ACTION
        }
        return "ok";
    }

}
