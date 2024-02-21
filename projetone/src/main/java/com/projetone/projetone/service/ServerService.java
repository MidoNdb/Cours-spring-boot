package com.projetone.projetone.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetone.projetone.dao.ServerRepository;
import com.projetone.projetone.entity.Server;

@Service
public class ServerService {
   
    @Autowired
    private ServerRepository serverRepository;

    public Server createServer(Server server){
        return serverRepository.save(server);

    }

    public Server updateServer(Server server, Long id){
        Optional<Server> optServer= serverRepository.findById(id);
        if (optServer.isPresent()) {
           var newServer=optServer.get();
           newServer.setId(server.getId());
           newServer.setName(server.getName()); 
           newServer.setStatus(server.getStatus());
           return serverRepository.save(newServer);
        }
        return null;
    }
}
