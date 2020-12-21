package com.ppc.api.dto.metric.visitors;

import com.ppc.api.entities.VisitorEntity;

import org.springframework.stereotype.Service;

@Service
public class MetricResponse {
    
    private String action;
    private VisitorEntity visitor;

    public MetricResponse() {};

    public MetricResponse(String action, VisitorEntity visitor) {
        this.action = action;
        this.visitor = visitor;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction (String action) {
        this.action = action;
    }

    public VisitorEntity getVisitor() {
        return this.visitor;
    }

    public void getVisitor(VisitorEntity visitor) {
        this.visitor = visitor;
    }
}
