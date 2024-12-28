package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Note;

@Repository
public interface INoteRepository extends CrudRepository<Note, Long>{
	@Query("SELECT n FROM Note n WHERE n.etudiant.id = :idEtd AND n.matiere.idMatiere = :idMatiere")
	List<Note> findByEtdMatiere(@Param("idEtd") Long idEtd, @Param("idMatiere") Long idMatiere);
	@Query("SELECT n FROM Note n WHERE n.etudiant.id = :idEtd")
	List<Note> findByEtd(@Param("idEtd") Long idEtd);
	@Query("SELECT n FROM Note n WHERE n.matiere.idMatiere = :idMatiere")
	List<Note> findByMatiere(@Param("idMatiere") Long idMatiere);
	@Query("SELECT n FROM Note n WHERE n.etudiant.classe.idclasse = :idClasse")
	List<Note> findByClasse(@Param("idClasse") Long idClasse);
}
