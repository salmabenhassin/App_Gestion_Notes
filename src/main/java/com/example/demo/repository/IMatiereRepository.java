package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Matiere;
import com.example.demo.entities.Note;

@Repository
public interface IMatiereRepository extends CrudRepository<Matiere, Long>{
	@Query("SELECT m FROM Matiere m WHERE m.M.idModule = :idModule")
	List<Matiere> findByModule(@Param("idModule") Long idModule);
}
