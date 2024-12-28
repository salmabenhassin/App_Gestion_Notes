package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Classe;
import com.example.demo.entities.Specialite;
import com.example.demo.repository.IClasseRepository;
import com.example.demo.repository.ISpecialiteRepository;

@Service
public class SpecServImp implements IspecServ{
@Autowired
private ISpecialiteRepository specRep;
@Autowired
private IClasseRepository classerep;
	@Override
	public Specialite addSpecialite(Specialite u) {
		return specRep.save(u);
	}

	@Override
	public List<Specialite> addlistspecialite(List<Specialite> c) {
		return (List<Specialite>) specRep.saveAll(c);
	}

	@Override
	public Specialite getSpecialitebyid(Long id) {
		return specRep.findById(id).get();
	}

	@Override
	public Specialite UpdateSpecialite(Specialite c, Long id) {
		Specialite Cl = specRep.findById(id).get();
		Cl.setNomSpecialite(c.getNomSpecialite());
		return specRep.save(Cl);
	}

	@Override
	public void DeleteSpecialite(Long id) {
     specRep.deleteById(id);		
	}

	@Override
	public List<Specialite> getAllSpecialite() {
		return (List<Specialite>) specRep.findAll();
	}

	@Override
	public Specialite addSpecialiteclasse(Specialite m, Long idclasse) {
		Classe c = classerep.findById(idclasse).get();
		m.setC2(c);

		return specRep.save(m);
		
	}
	
	@Override
	public List<Specialite> findByClasse(Long idClasse){
		return (List<Specialite>) specRep.findByClasse(idClasse);
	}

}
