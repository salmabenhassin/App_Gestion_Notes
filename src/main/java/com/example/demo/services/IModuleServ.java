package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Module;


public interface IModuleServ {
	public Module addModule(Module u);	
	public List<Module> addlistmodules(List<Module> c);
	public Module getmodulebyid(Long id);
	public Module UpdateModule(Module c,Long id);
    public void DeleteModule(Long id);
	public List<Module> getAllModules();
	//module classe
	public Module addModuleclasse(Module m, Long idclasse);
	public List<Module> findByClasse(Long idClasse);
}
