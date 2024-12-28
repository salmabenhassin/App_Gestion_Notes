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

import com.example.demo.entities.Specialite;
import com.example.demo.services.SpecServImp;

@RestController
public class SpecController {
	@Autowired
	private SpecServImp specServ;
	@PostMapping(value = "/addSpecialite")
	public Specialite addSpecialite(@RequestBody Specialite u) {
			return specServ.addSpecialite(u);
		
	}
	@PostMapping(value = "/addlistSpecailites")
	public List<Specialite> addlistspecialite(@RequestBody List<Specialite> u) {
			return specServ.addlistspecialite(u);
		
	}
	@PutMapping(value = "/UpdateSpecialite/{idu}")
	public Specialite UpdateSpecialite(@RequestBody Specialite u,@PathVariable("idu")Long idModule) {
			return specServ.UpdateSpecialite(u, idModule);
	}
	@DeleteMapping(value = "/DeleteSpecialite/{idu}")
	public void DeleteSpecialite(@PathVariable("idu")Long id) {
		specServ.DeleteSpecialite(id);
	}
	@GetMapping(value = "/getAllSpecialites")
	public List<Specialite> getSpecialites(){
		return specServ.getAllSpecialite();
	}
	@GetMapping(value = "/getSpecialiteByID/{idu}")
	public Specialite getSpecialitesbyId(@PathVariable("idu")Long id){
		return specServ.getSpecialitebyid(id);
	}

	@PostMapping(value = "/addClasseASpecialite/{id}")
	public Specialite addspecialiteclass(@RequestBody Specialite m,@PathVariable("id")Long id) {
		
			return specServ.addSpecialiteclasse(m, id);
		
	}

}
