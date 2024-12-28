package com.example.demo.repository;

import com.example.demo.entities.Etudiant;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant, Long>{
	@Query("SELECT e FROM Etudiant e WHERE e.classe.idclasse = :idClasse")
	List<Etudiant> findByClasse(@Param("idClasse") Long idClasse);
	@Query("SELECT e FROM Etudiant e WHERE e.email = :email")
	Optional<Etudiant> findByEmail(@Param("email") String email);


}






