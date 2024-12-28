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

import com.example.demo.entities.Classe;
import com.example.demo.entities.Module;
import com.example.demo.services.ClassServImp;
import com.example.demo.services.ModuleServImp;

@RestController
public class ModuleController {
	@Autowired
	private ModuleServImp modServ;
	
	@PostMapping(value = "/addModule")
	public Module addModule(@RequestBody Module u) {
			return modServ.addModule(u);
		
	}
	@PostMapping(value = "/addlistModules")
	public List<Module> addModulelistes(@RequestBody List<Module> u) {
			return modServ.addlistmodules(u);
		
	}
	@PutMapping(value = "/UpdateModule/{idu}")
	public Module UpdateModule(@RequestBody Module u,@PathVariable("idu")Long idModule) {
			return modServ.UpdateModule(u, idModule);
	}
	@DeleteMapping(value = "/DeleteModule/{idu}")
	public void DeleteModule(@PathVariable("idu")Long id) {
		modServ.DeleteModule(id);
	}
	@GetMapping(value = "/getAllModules")
	public List<Module> getmodules(){
		return modServ.getAllModules();
	}
	@GetMapping(value = "/getModuleByID/{idu}")
	public Module getmodulesbyId(@PathVariable("idu")Long id){
		return modServ.getmodulebyid(id);
	}

	@PostMapping(value = "/addClasseAmodule/{id}")
	public Module addModuleaclasse(@RequestBody Module m,@PathVariable("id")Long id) {
		
			return modServ.addModuleclasse(m, id);
		
	}
	@GetMapping(value = "/getModuleByClasse/{idCLASSE}")
	public List<Module> getModuleByClasse(@PathVariable("idCLASSE")Long idCLASSE){
		return modServ.findByClasse(idCLASSE);
	}
}
