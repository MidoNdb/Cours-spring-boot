package com.projetone.projetone.service;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projetone.projetone.dao.CompanyRepository;
import com.projetone.projetone.entity.Company;

@Service
public class Compenyservice {
    @Autowired
    private CompanyRepository companyRepository;
    public ResponseEntity<Object> createCompany (Company company){
        try {
            companyRepository.save(company);
            return ResponseEntity.ok().body("created successfully");  
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        
    }
    public ResponseEntity<Object> updateCompany(Company company, Long id){
        Optional<Company> optionalC=companyRepository.findById(id);
        if (optionalC.isPresent()) {
            var newC=optionalC.get();
            newC.setId(company.getId());
            newC.setName(company.getName());
            newC.setMail(company.getMail());
            newC.setPhone(company.getPhone());
            companyRepository.save(newC);
            return ResponseEntity.ok().body("updated successfully");
        }
        return null;
    }

    public ResponseEntity<Object> getCompenies(){
        var compenies= companyRepository.findAll();
        return ResponseEntity.ok().body(compenies);

    }

    public ResponseEntity<Object> deleteCompany(Long id){
        var optC=companyRepository.findById(id);

        if (optC.isPresent()) {
            companyRepository.deleteById(id);
            return ResponseEntity.ok().body("deleted successfuly");
        }
        else return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<Object> afficherByName(String name){
        return ResponseEntity.ok().body(companyRepository.findByName(name));
    }
    public ResponseEntity<Object> afficherByPhone(String phone){
        return ResponseEntity.ok().body(companyRepository.findByPhone(phone));
    }
    public ResponseEntity<Object> afficherByMail(String mail){
        return ResponseEntity.ok().body(companyRepository.findByMail(mail));
    }
    
}
