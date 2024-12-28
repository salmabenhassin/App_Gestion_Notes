package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Classe;


public interface IClasseServ {
	public Classe addClasse(Classe u);	
	public List<Classe> addlistclasses(List<Classe> c);
	public Classe getclassebyid(Long id);
	public Classe UpdateClasse(Classe c,Long idclasse);
    public void DeleteClasse(Long idclasse);
	public List<Classe> getAllClasses();	
	//sur table classe module
	public Classe addaModuleclasse(Long idclasse,Long idModule);
	public Classe addSpecialiteclasse(Long idclasse,Long idspecialite);

		

}
