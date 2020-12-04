package com.ppc.api.staticCnf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppc.api.dto.metric.MetricReceivedDto;

import org.springframework.stereotype.Service;

/**
 * Actions for WS message received, allow for filter and apply the corresponding
 * actions
 */
@Service
public class WsDispatchActions {
    public enum Visitor {
        CREATE_VISITOR
    }

    public enum Pathing {
        CREATE_PATHING
    }

    public String getActionFromClient(String wsPayload) {
        String msg = wsPayload;
        ObjectMapper objectMapper = new ObjectMapper();
        MetricReceivedDto metricReceivedDto;

        try {
           metricReceivedDto = objectMapper.readValue(msg, MetricReceivedDto.class);
           return metricReceivedDto.getAction();
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }
}