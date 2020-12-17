package com.ppc.api.services;

import java.io.IOException;

import com.ppc.api.dto.metric.MetricReceivedDto;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
public class WsMessageDispatcherVisitor {

    VisitorEntityService visitorEntityService;
    MetricReceivedDto metricReceivedDto;

    WsMessageDispatcherVisitor(VisitorEntityService visitorEntityService, MetricReceivedDto metricReceivedDto) {
        this.visitorEntityService = visitorEntityService;
        this.metricReceivedDto = metricReceivedDto;
    }

    public String createVisitor(String action, Object data, WebSocketSession session) throws IOException {
        System.out.println("ACTION : " + action );
        System.out.println("DATA : " + data);
        MetricReceivedDto metricReceivedDto = new MetricReceivedDto(action, data);
        this.visitorEntityService.createVisitorEntity(metricReceivedDto, session);
        
        return "ok";
    }

}
