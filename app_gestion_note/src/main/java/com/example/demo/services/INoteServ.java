package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Note;

public interface INoteServ {

	public Note ajouter_NOTE (Note note);
	public List<Note> addlistNotes(List<Note> notes);
	public Note chercher_Note(Long id);
	public void supprimer_NOTE(Long id);
	public List<Note> afficher_NOTE();
	public void modifier_NOTE(Long id, Note updatedNote);
	public List<Note> afficher_Note_ETDMATIERE(Long idEtd, Long idClasse);
	public List<Note> NotesByEtd(Long idEtd);
	public List<Note> findByClasse(Long idClasse);
	public void addEtudiant(Long idNote, Long idEtd);
	public void addMatiere(Long idNote, Long idMat);
}
