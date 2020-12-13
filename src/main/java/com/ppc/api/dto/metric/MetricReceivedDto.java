package com.ppc.api.dto.metric;

import org.springframework.stereotype.Service;

@Service
public class MetricReceivedDto {
    private String action; // Send by client but MUST corresponding to enum value present in WsDispatchActions

    // Send by client but MUST be compliant with the service called;
    private Object data;

    MetricReceivedDto(){}

    public MetricReceivedDto(String action, Object data) {
        this.action = action;
        this.data = data;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction(){
        return this.action;
    }

    public void setData (Object data) {
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }
    
}