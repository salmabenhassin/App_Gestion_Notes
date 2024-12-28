package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Matiere;


public interface IMatiereServ {
	public Matiere addMatiere(Matiere u);	
	public List<Matiere> addlistMatieres(List<Matiere> c);
	public Matiere getmatierebyid(Long id);
	public Matiere UpdateMatiere(Matiere c,Long id);
    public void DeleteMatiere(Long id);
	public List<Matiere> getAllMatieres();
	public List<Matiere> getByModule(Long idMod);
	public void addMatiereModule(Long idmat, Long idmodule);
}
