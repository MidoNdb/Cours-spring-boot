package com.projetone.projetone.web;

//import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetone.projetone.entity.Company;
import com.projetone.projetone.service.Compenyservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private Compenyservice service;


    @PostMapping("/create")
    public ResponseEntity<Object> createCompany(@RequestBody Company company) {  
        return service.createCompany(company); 
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCompany(@PathVariable Long id, @RequestBody Company company) {
     
        return service.updateCompany(company, id);
     
    }

    @GetMapping
    public ResponseEntity<Object> getCompanies() {
        return service.getCompenies();
    }

    @GetMapping
    public ResponseEntity<Object> getCompanyByMail(@RequestParam String param) {
        return service.afficherByMail(param);
    }



    @PutMapping("selectByMail/{id}")
    public String putMethodName(@PathVariable String mail, @RequestBody String entity) {
        return entity;
    }
    
    
}
