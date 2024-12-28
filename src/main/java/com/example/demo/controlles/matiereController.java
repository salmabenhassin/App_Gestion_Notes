package com.example.demo.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Matiere;
import com.example.demo.entities.Specialite;
import com.example.demo.services.MatiereservImp;

@RestController
public class matiereController {
	@Autowired
	private MatiereservImp matserv;
	@PostMapping(value = "/addMatiere")
	public ResponseEntity<?> addMatiere(@RequestBody Matiere u) {
			try { matserv.addMatiere(u);
            return ResponseEntity.ok(u);
			}
			catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }

		
	}
	@PostMapping(value = "/addlistMatieres")
	public List<Matiere> addlistMatiere(@RequestBody List<Matiere> u) {
			return matserv.addlistMatieres(u);
		
	}
	@PutMapping(value = "/UpdateMatiere/{idu}")
	public Matiere Updatematiere(@RequestBody Matiere u,@PathVariable("idu")Long idMatiere) {
			return matserv.UpdateMatiere(u, idMatiere);
	}
	@DeleteMapping(value = "/Deletematiere/{idu}")
	public void Deletematiere(@PathVariable("idu")Long id) {
		matserv.DeleteMatiere(id);
	}
	@GetMapping(value = "/getAllMatieres")
	public List<Matiere> getMatieres(){
		return matserv.getAllMatieres();
	}
	@GetMapping(value = "/getMatiereByID/{idu}")
	public Matiere getmatierebyId(@PathVariable("idu")Long id){
		return matserv.getmatierebyid(id);
	}

	@PutMapping(value = "/addModuleMatiere/{idmat}/{id}")
	public void addmoduleMatiere(@PathVariable("idmat") Long idmat,@PathVariable("id")Long id) {
		
		matserv.addMatiereModule(idmat, id);
		
	}
	@GetMapping(value = "/getMatiereByMod/{idMOD}")
	public List<Matiere> getMatiereByMod(@PathVariable("idMOD")Long idMOD){
		return matserv.getByModule(idMOD);
	}

}
