package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Module;
import com.example.demo.entities.Note;
import com.example.demo.repository.IMatiereRepository;
import com.example.demo.repository.IModuleRepository;
import com.example.demo.repository.INoteRepository;

@Service
public class MatiereservImp  implements IMatiereServ{
@Autowired
private IMatiereRepository matRep;
@Autowired
private IModuleRepository modrep;
@Autowired
private INoteRepository noteRepo;

	@Override
	public Matiere addMatiere(Matiere u) {
        validateMatiere(u); // Valider la matière avant l'ajout
		return matRep.save(u);
	}

	@Override
	public List<Matiere> addlistMatieres(List<Matiere> c) {
		
		return (List<Matiere>) matRep.saveAll(c);
	}

	@Override
	public Matiere getmatierebyid(Long id) {
		return matRep.findById(id).get();
	}
	@Override
	public void DeleteMatiere(Long id) {
		for(Note n: noteRepo.findByMatiere(id))
			noteRepo.deleteById(n.getId());
		matRep.deleteById(id);
		
	}

	@Override
	public Matiere UpdateMatiere(Matiere c, Long id) {
        validateMatiere(c); // Valider la matière avant l'ajout
		Matiere Cl = matRep.findById(id).get();
		Cl.setNomMatiere(c.getNomMatiere());
		Cl.setCoifMatiere(c.getCoifMatiere());
		return matRep.save(Cl);
	
	}
	@Override
	public List<Matiere> getAllMatieres() {

		return (List<Matiere>) matRep.findAll();
	}

	@Override
	public void addMatiereModule(Long idmat, Long idmodule) {
		Module c = modrep.findById(idmodule).get();
		Matiere m = matRep.findById(idmat).get();
		m.setM(c);
		matRep.save(m);
	}
	@Override
	public List<Matiere> getByModule(Long idMod) {
		return (List<Matiere>) matRep.findByModule(idMod);
	}
	 // Méthode de validation pour vérifier que le coefficient de matière est strictement positif
    private void validateMatiere(Matiere matiere) {
        if (matiere.getCoifMatiere() <= 0) {
            throw new IllegalArgumentException("Le coefficient de la matière doit être strictement positif.");
        }
    }




}
