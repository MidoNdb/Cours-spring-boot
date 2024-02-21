package com.projetone.projetone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetone.projetone.entity.Server;
@Repository
public interface ServerRepository extends JpaRepository<Server,Long> {

    
} 
