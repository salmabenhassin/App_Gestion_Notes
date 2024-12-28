package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Module;

@Repository
public interface IModuleRepository extends CrudRepository<Module,Long>{
	@Query("SELECT m FROM Module m WHERE m.C.idclasse = :idClasse")
	List<Module> findByClasse(@Param("idClasse") Long idClasse);
}
