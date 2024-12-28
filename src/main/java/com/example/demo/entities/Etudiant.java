package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Etudiant implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	int cin;
	@Temporal(TemporalType.DATE)
	Date daten;
	String lieun;
	String Adresse;
	int tel;
	String email;
	String nom;
	String prenom;
	@ManyToOne(fetch = FetchType.EAGER)
	//@JsonBackReference
	Classe classe;
	@OneToMany(mappedBy = "etudiant")
	@JsonIgnoreProperties({"etudiant"})
	@ToString.Exclude
	List<Note> notes;
	
	/*public Etudiant(int cin, Date daten, String lieun, String adresse, int tel, String email, String nom,
			String prenom) {
		this.cin = cin;
		this.daten = daten;
		this.lieun = lieun;
		this.Adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
	}*/
	public void setClasseToNull() {
	    this.classe = null;
	}
	
}
