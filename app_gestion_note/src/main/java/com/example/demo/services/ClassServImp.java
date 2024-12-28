package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Classe;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Module;
import com.example.demo.entities.Specialite;
import com.example.demo.repository.IClasseRepository;
import com.example.demo.repository.IEtudiantRepository;
import com.example.demo.repository.IModuleRepository;
import com.example.demo.repository.ISpecialiteRepository;

@Service

public class ClassServImp implements IClasseServ{
@Autowired
private IClasseRepository classerep;
@Autowired
private IModuleRepository modulerep;
@Autowired
private ISpecialiteRepository specrep;
@Autowired
private IEtudiantRepository etdRepo;

	@Override
	public Classe addClasse(Classe u) {
        validateClasse(u); 
		return classerep.save(u);
	}

	@Override
	public List<Classe> addlistclasses(List<Classe> c) {
		return(List<Classe>) classerep.saveAll(c);
	}

	@Override
	public Classe getclassebyid(Long id) {
		return classerep.findById(id).get();
	}

	@Override
	public Classe UpdateClasse(Classe c, Long idclasse) {
        validateClasse(c); // Valider la classe avant l'ajout
		Classe Cl=classerep.findById(idclasse).get();
		Cl.setNomClasse(c.getNomClasse());
		Cl.setNiveauClasse(c.getNiveauClasse());
		return classerep.save(Cl);
	}

	@Override
	public void DeleteClasse(Long idclasse) {
		for(Etudiant etd: etdRepo.findByClasse(idclasse))
			etd.setClasseToNull();
		for(Module etd: modulerep.findByClasse(idclasse))
			etd.setClasseToNull();
		for(Specialite etd: specrep.findByClasse(idclasse))
			etd.setClasseToNull();
		classerep.deleteById(idclasse);		
	}

	@Override
	public List<Classe> getAllClasses() {

		return(List<Classe>) classerep.findAll();
	}

	@Override
	public Classe addaModuleclasse(Long idclasse, Long idModule) {
		Classe CL= classerep.findById(idclasse).get();
		Module MD= modulerep.findById(idModule).get();
		CL.addModule(MD);
		return classerep.save(CL);
	}

	@Override
	public Classe addSpecialiteclasse(Long idclasse, Long idspecialite) {
		Classe CL= classerep.findById(idclasse).get();
		Specialite sp= specrep.findById(idspecialite).get();
		CL.addSpecialite(sp);
		return classerep.save(CL);
	}
	// Méthode pour ajouter un module à une classe
    public Classe addModuleToClasse(Long classeId, Module module) {
        Classe cl = classerep.findById(classeId).get();
         cl.addModule(module);
         return classerep.save(cl);
       
    }

    // Méthode pour supprimer un module d'une classe
    public Classe removeModuleFromClasse(Long classeId, Module module) {
    	 Classe cl = classerep.findById(classeId).get();
         cl.removeModule(module);
           return classerep.save(cl);
       
    }
 // Méthode pour ajouter une spécialité à une classe
    public Classe addSpecialiteToClasse(Long classeId, Specialite specialite) {
        Classe classe = classerep.findById(classeId).orElse(null);
        if (classe != null) {
            classe.addSpecialite(specialite);
            return classerep.save(classe);
        } else {
          
            return null;
        }
    }

    // Méthode pour supprimer une spécialité d'une classe
    public Classe removeSpecialiteFromClasse(Long classeId, Specialite specialite) {
        Classe classe = classerep.findById(classeId).orElse(null);
        if (classe != null) {
            classe.removespecialite(specialite);
            return classerep.save(classe);
        } else {
           
            return null;
        }
    }

 // Méthode de validation personnalisée pour vérifier la non-nullité des champs de la classe
    private void validateClasse(Classe classe) {
        if (classe == null || classe.getNomClasse() == null || classe.getNiveauClasse() == 0) {
            throw new IllegalArgumentException("Les champs de la classe ne peuvent pas être nuls.");
        }
    }
}
