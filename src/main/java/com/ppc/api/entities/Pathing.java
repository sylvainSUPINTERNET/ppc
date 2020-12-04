package com.ppc.api.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.UpdateTimestamp;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "pathing")
public class Pathing {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float[][] pathMatrix;
    private String action;
    private String appLocation; // e.g /home

    public Pathing() {
    };

    public Pathing(float[][] pathMatrix, String action, String appLocation) {
        this.pathMatrix = pathMatrix;
        this.action = action;
        this.appLocation = appLocation;
    }

    public String getAction() {
        return action;
    }

    public void setAppLocation(String appLocation) {
        this.appLocation = appLocation;
    }

    public String getAppLocation(String appLocation) {
        return this.appLocation;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    public float[][] getPathMatrix() {
        return pathMatrix;
    }

    public void setPathMatrix(float[][] pathMatrix) {
        this.pathMatrix = pathMatrix;
    }


    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;



}
