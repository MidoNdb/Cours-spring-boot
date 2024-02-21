package com.projetone.projetone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetone.projetone.entity.Company;
import java.util.List;



@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{

    public Company findByMail(String mail);
    public List<Company> findByName(String name);
    public Company  findByPhone(String phone);
} 
