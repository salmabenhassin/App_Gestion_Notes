package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Module;
import com.example.demo.entities.Specialite;
@Repository
public interface ISpecialiteRepository extends CrudRepository <Specialite,Long>{
	@Query("SELECT s FROM Specialite s WHERE s.C2.idclasse = :idClasse")
	List<Specialite> findByClasse(@Param("idClasse") Long idClasse);
}
