package com.ppc.api.services;

import com.ppc.api.dto.metric.MetricReceivedDto;

import org.springframework.stereotype.Service;

@Service
public class WsMessageDispatcherVisitor {


    VisitorEntityService visitorEntityService;
    MetricReceivedDto metricReceivedDto;

    WsMessageDispatcherVisitor(VisitorEntityService visitorEntityService,MetricReceivedDto metricReceivedDto) {
        this.visitorEntityService = visitorEntityService;
        this.metricReceivedDto = metricReceivedDto;
    }

    public String createVisitor (String action, Object data) {
        System.out.println("ACTION : " + action );
        System.out.println("DATA : " + data);
        MetricReceivedDto metricReceivedDto = new MetricReceivedDto(action, data);
        this.visitorEntityService.createVisitorEntity(metricReceivedDto);
        
        return "ok";
    }

}
