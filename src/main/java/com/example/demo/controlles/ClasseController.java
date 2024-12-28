package com.example.demo.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Classe;
import com.example.demo.entities.Module;
import com.example.demo.services.ClassServImp;

@RestController
public class ClasseController {
	@Autowired
	private ClassServImp classeserv;
	@PostMapping(value = "/addclasse")
	public ResponseEntity<?> addClasse(@RequestBody Classe u) {
		try {
			 classeserv.addClasse(u);
			return ResponseEntity.ok(u);
		}
		catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
		
	}
	@PostMapping(value = "/addlistclasse")
	public List<Classe> addListClasses(@RequestBody List<Classe> u) {
			return classeserv.addlistclasses(u);
		
	}
	@PutMapping(value = "/UpdateClasse/{idu}")
	public Classe UpdateClasse(@RequestBody Classe u,@PathVariable("idu")Long idClasse) {
			return classeserv.UpdateClasse(u, idClasse);
	}
	@DeleteMapping(value = "/DeleteClasse/{idu}")
	public void DeleteClasse(@PathVariable("idu")Long idclasse) {
		classeserv.DeleteClasse(idclasse);
	}
	@GetMapping(value = "/getAllClasses")
	public List<Classe> getclasses(){
		return classeserv.getAllClasses();
	}
	@GetMapping(value = "/getClasseByID/{idu}")
	public Classe getclassesbyId(@PathVariable("idu")Long idClasse){
		return classeserv.getclassebyid(idClasse);
	}
	@PostMapping("/addModule/{id1}")
    public Classe addModuleToClasse(@PathVariable("id1") Long classeId, @RequestBody Module module) {
		 return classeserv.addModuleToClasse(classeId, module);
      
    }

   
}
