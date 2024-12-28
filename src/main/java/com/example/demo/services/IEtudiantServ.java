package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Etudiant;

public interface IEtudiantServ {
	public Etudiant ajouter_ETD (Etudiant etd);
	public List<Etudiant> addlist_ETDS(List<Etudiant> etds);
	public Etudiant chercher_ETD(Long id);
	public void supprimer_ETD(Long id);
	public List<Etudiant> afficher_ETD();
	public void modifier_ETD(Long id, Etudiant updatedEtd);
	public void affecter_ETD_CLASSE(Long idETD, Long idCLASSE);
	public List<Etudiant> afficher_ETDS_CLASSE(Long idCLASSE);
}
