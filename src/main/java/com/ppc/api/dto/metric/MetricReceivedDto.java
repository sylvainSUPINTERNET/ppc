package com.ppc.api.dto.metric;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetricReceivedDto {
    @JsonProperty("action")
    private String action; // Send by client but MUST corresponding to enum value present in WsDispatchActions

    @JsonProperty("data") // Send by client but MUST be compliant with the service called;
    private String data;

    public MetricReceivedDto(String action, String data) {
        this.action = action;
        this.data = data;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction(){
        return this.action;
    }

    public void setData (String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }
    
}