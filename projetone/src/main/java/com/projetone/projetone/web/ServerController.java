package com.projetone.projetone.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetone.projetone.entity.Server;
import com.projetone.projetone.service.ServerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/server")
public class ServerController {
    
    @Autowired
    private ServerService service;

    @PostMapping("/create")
    public ResponseEntity<Object> createServer(@RequestBody Server server) {
        try {
            service.createServer(server);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateServer(@PathVariable Long id, @RequestBody Server server) {
        try {
            service.updateServer(server, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
          return ResponseEntity.internalServerError().build();
        }
    }
    

}
