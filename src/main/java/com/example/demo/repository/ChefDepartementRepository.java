package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ChefDepartement;

@Repository
public interface ChefDepartementRepository extends CrudRepository<ChefDepartement,String>{

}
