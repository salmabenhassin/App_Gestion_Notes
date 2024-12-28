package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Specialite;


public interface IspecServ {
	public Specialite addSpecialite(Specialite u);	
	public List<Specialite> addlistspecialite(List<Specialite> c);
	public Specialite getSpecialitebyid(Long id);
	public Specialite UpdateSpecialite(Specialite c,Long id);
    public void DeleteSpecialite(Long id);
	public List<Specialite> getAllSpecialite();
	
	public Specialite addSpecialiteclasse(Specialite m, Long idclasse);
	public List<Specialite> findByClasse(Long idClasse);
}
