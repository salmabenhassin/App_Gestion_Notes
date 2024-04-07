package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Note;

@Repository
public interface INoteRepository extends CrudRepository<Note, Long>{

}
