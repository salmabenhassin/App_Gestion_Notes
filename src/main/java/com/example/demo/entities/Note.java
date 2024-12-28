package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
public class Note implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Enumerated(EnumType.STRING)
	TypeNote type;
	float note;
	@ManyToOne(fetch = FetchType.EAGER)
	//@JsonBackReference
	Matiere matiere;
	@ManyToOne
	@JsonIgnoreProperties({"notes", "classe"})
	Etudiant etudiant;
}
