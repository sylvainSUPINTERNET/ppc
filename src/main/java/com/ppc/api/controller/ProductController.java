package com.ppc.api.controller;

import com.ppc.api.dto.product.ProductCreatedDto;
import com.ppc.api.ws.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/${API_VERSION}/products")
public class ProductController {

    private ProductCreatedDto productCreatedDto;

    public ProductController(ProductCreatedDto productCreatedDto) {
        this.productCreatedDto = productCreatedDto;
    }

    @PostMapping
    public ResponseEntity notifyNewProduct(@RequestBody ProductCreatedDto productCreatedDto) {
        // TODO here send the message to WebSocketHandler
        // When we get this message, we are able to send it to /socket for the moment, but we should create multiple handler ... so one for /product for exemple and other for other topics we need
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("OK");
    }

    @GetMapping
    public ResponseEntity getProducts() {
        Map<String, String> test = new HashMap<>();
        test.put("Ok","ok");
        return ResponseEntity.status(200).body(test);
    }

    
}
