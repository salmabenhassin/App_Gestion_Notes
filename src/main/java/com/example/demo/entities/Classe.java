package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode

@Entity
public class Classe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idclasse;
	private String nomClasse;
	private int niveauClasse;
	
	@OneToMany(mappedBy = "C")
	@JsonIgnoreProperties("c")
	@ToString.Exclude
	private List<Module> listeModules;
	
	
	@OneToMany(mappedBy = "C2")
	@JsonIgnoreProperties("C2")
	@ToString.Exclude
	private List<Specialite> listeSpecialites;
	
	public void addModule(Module module) {
		listeModules.add(module);
		
	}
	public void removeModule(Module module) {
		listeModules.remove(module);
		
	}
	public void addSpecialite(Specialite spec) {
		listeSpecialites.add(spec);		
	}
	public void removespecialite(Specialite spec) {
		listeSpecialites.remove(spec);
		
	}
}