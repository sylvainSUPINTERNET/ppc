package com.ppc.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ppc.api.entities.VisitorEntity;
import com.ppc.api.services.VisitorEntityService;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitors")
public class VisitorController {
    
    VisitorEntityService visitorEntityService;

    VisitorController(VisitorEntityService visitorEntityService){
        this.visitorEntityService = visitorEntityService;
    }
    
    @GetMapping
    public ResponseEntity<?> getVisitors(@RequestParam int page, @RequestParam int size, @RequestParam String filter) {
        try {
            Page<VisitorEntity> visitors = this.visitorEntityService.getVisitors(page, size, filter);
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(visitors);
        } catch (Exception e) {
            Map error = new HashMap<String, Object>();
            error.put("message", e.getMessage());
            error.put("cause", e.getCause());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

}
