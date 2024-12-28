package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Module implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;
	private String nomModule;
	private int CoifModule;
	
	@OneToMany(mappedBy = "M")
	@JsonIgnoreProperties("m")
	@ToString.Exclude
	private List<Matiere> listeMatieres;
	
	
	@ManyToOne
	@JsonIgnoreProperties("listeModules")
	private Classe C;
	

	public void setClasseToNull() {
	    this.C = null;
	}
	
}