package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Classe;

@Repository
public interface IClasseRepository extends CrudRepository<Classe, Long>{

}
