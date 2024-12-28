package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Classe;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Module;
import com.example.demo.repository.IClasseRepository;
import com.example.demo.repository.IMatiereRepository;
import com.example.demo.repository.IModuleRepository;

@Service
public class ModuleServImp implements IModuleServ{
	@Autowired
	private IModuleRepository modRep;
	@Autowired
	private IClasseRepository classerep;
	@Autowired
	private IMatiereRepository matiereRepo;

	@Override
	public Module addModule(Module u) {
		return modRep.save(u);
	}

	@Override
	public List<Module> addlistmodules(List<Module> c) {
		return (List<Module>) modRep.saveAll(c);
	}

	@Override
	public Module getmodulebyid(Long id) {
		return modRep.findById(id).get();
	}

	@Override
	public Module UpdateModule(Module c, Long id) {
		Module Cl=modRep.findById(id).get();
		Cl.setNomModule(c.getNomModule());
		Cl.setCoifModule(c.getCoifModule());
		return modRep.save(Cl);
	}
	@Override
	public List<Module> getAllModules() {
		
		return (List<Module>) modRep.findAll();
	}

	@Override
	public void DeleteModule(Long id) {
		for(Matiere m: matiereRepo.findByModule(id))
			matiereRepo.deleteById(m.getIdMatiere());
		modRep.deleteById(id);
		
	}

	@Override
	public Module addModuleclasse(Module m, Long idclasse) {
		Classe c = classerep.findById(idclasse).get();
		m.setC(c);

		return modRep.save(m);
	}
	
	@Override
	public List<Module> findByClasse(Long idClasse){
		return (List<Module>) modRep.findByClasse(idClasse);
	}
	

}
