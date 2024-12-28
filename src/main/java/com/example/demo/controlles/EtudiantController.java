package com.example.demo.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Etudiant;
import com.example.demo.services.EtudiantServImp;

@RestController
public class EtudiantController {
	@Autowired
	private EtudiantServImp etdServ;
	
	@PostMapping(value = "/addEtudiant")
	public Etudiant addEtudiant(@RequestBody Etudiant etd) {
		return etdServ.ajouter_ETD(etd);
	}
	
	@PostMapping(value = "/AddListEtudiants")
	public List<Etudiant> addListEtudiants(@RequestBody List<Etudiant> etds){
		return etdServ.addlist_ETDS(etds);
	}
	
	@GetMapping(value = "/getEtudiant/{id}")
	public Etudiant getEtudiant(@PathVariable("id") Long id) {
		return etdServ.chercher_ETD(id);
	}
	
	@DeleteMapping(value = "/deleteEtudiant/{id}")
    public void deleteEtudiant(@PathVariable("id") Long id) {
        etdServ.supprimer_ETD(id);
    }

    @GetMapping(value = "/getAllEtudiants")
    public List<Etudiant> getAllEtudiants() {
        return etdServ.afficher_ETD();
    }

    @PutMapping(value = "/updateEtudiant/{id}")
    public void updateEtudiant(@PathVariable("id") Long id, @RequestBody Etudiant updatedEtd) {
        etdServ.modifier_ETD(id, updatedEtd);
    }

    @PutMapping(value = "/affecterEtudiantClasse/{idETD}/{idCLASSE}")
    public void affecterEtudiantClasse(@PathVariable("idETD") Long idETD, @PathVariable("idCLASSE") Long idCLASSE) {
        etdServ.affecter_ETD_CLASSE(idETD, idCLASSE);
    }

    @GetMapping(value = "/afficherEtudiantsClasse/{idCLASSE}")
    public List<Etudiant> afficherEtudiantsClasse(@PathVariable("idCLASSE") Long idCLASSE) {
        return etdServ.afficher_ETDS_CLASSE(idCLASSE);
    }
}
