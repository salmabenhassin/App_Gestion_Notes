package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Classe;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Note;
import com.example.demo.repository.IClasseRepository;
import com.example.demo.repository.IEtudiantRepository;
import com.example.demo.repository.INoteRepository;
@Transactional
@Service
public class EtudiantServImp implements IEtudiantServ{
	@Autowired
	IEtudiantRepository etudiantRepo;
	@Autowired
	IClasseRepository classeRepo;
	@Autowired
	INoteRepository noteRepo;
	
	@Override
	public Etudiant ajouter_ETD(Etudiant etd) {
	    return (Etudiant) etudiantRepo.save(etd);
	}
	@Override
	public List<Etudiant> addlist_ETDS(List<Etudiant> etds) {
		return (List<Etudiant>) etudiantRepo.saveAll(etds);
	}
	
	@Override
	public Etudiant chercher_ETD(Long id) {
		return etudiantRepo.findById(id).get();
	}
	@Override
	public void supprimer_ETD(Long id) {
		for(Note n: noteRepo.findByEtd(id))
			noteRepo.deleteById(n.getId());
		etudiantRepo.deleteById(id);
	}

	@Override
	public List<Etudiant> afficher_ETD() {
		List<Etudiant> etudiants= (List<Etudiant>) etudiantRepo.findAll();
		return etudiants;
	}
	
	@Override
    public void modifier_ETD(Long id, Etudiant updatedEtd) {
        Etudiant Etd = etudiantRepo.findById(id).get();

        Etd.setCin(updatedEtd.getCin());
        Etd.setDaten(updatedEtd.getDaten());
        Etd.setLieun(updatedEtd.getLieun());
        Etd.setAdresse(updatedEtd.getAdresse());
        Etd.setTel(updatedEtd.getTel());
        Etd.setEmail(updatedEtd.getEmail());
        Etd.setNom(updatedEtd.getNom());
        Etd.setPrenom(updatedEtd.getPrenom());
        //existingEtd.setClasse(updatedEtd.getClasse());
        Etd.setNotes(updatedEtd.getNotes());
        etudiantRepo.save(Etd);
    }
	@Override
	public void affecter_ETD_CLASSE(Long idETD, Long idCLASSE) {
		Etudiant etd = etudiantRepo.findById(idETD).get();
		Classe classe = classeRepo.findById(idCLASSE).get();
		etd.setClasse(classe);
		etudiantRepo.save(etd);
	}
	@Override 
	public List<Etudiant> afficher_ETDS_CLASSE(Long idCLASSE){
		List<Etudiant> etds = (List<Etudiant>) etudiantRepo.findByClasse(idCLASSE);
		return etds;
	}
}

