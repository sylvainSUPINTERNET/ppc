package com.ppc.api.controller;

import java.util.HashMap;
import java.util.Map;

import com.ppc.api.services.VisitorEntityService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitors")
public class VisitorController {
    
    VisitorEntityService visitorEntityService;

    VisitorController(VisitorEntityService visitorEntityService){
        this.visitorEntityService = visitorEntityService;
    }


    @GetMapping
    public ResponseEntity<?> getVisitors() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.visitorEntityService.getVisitors());
        } catch (Exception e) {
            Map error = new HashMap<String, Object>();
            error.put("message", e.getMessage());
            error.put("cause", e.getCause());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

}
