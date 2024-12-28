package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Note;
import com.example.demo.repository.IEtudiantRepository;
import com.example.demo.repository.IMatiereRepository;
import com.example.demo.repository.INoteRepository;

@Service
public class NoteServImp implements INoteServ {
    @Autowired
    INoteRepository noteRepo;
    @Autowired
    IEtudiantRepository etdRepo;
    @Autowired
    IMatiereRepository matRepo;

    @Override
    public Note ajouter_NOTE(Note note) {
        validateNoteValue(note.getNote()); // Validate note before saving
        return noteRepo.save(note);
    }

    @Override
    public List<Note> addlistNotes(List<Note> notes) {
        for (Note note : notes) {
            validateNoteValue(note.getNote()); // Validate each note in the list
        }
        return (List<Note>)noteRepo.saveAll(notes);
    }

    @Override
    public Note chercher_Note(Long id) {
        return noteRepo.findById(id).orElse(null); // Return null if not found
    }

    @Override
    public void supprimer_NOTE(Long id) {
        noteRepo.deleteById(id);
    }

    @Override
    public List<Note> afficher_NOTE() {
        return (List<Note>)noteRepo.findAll();
    }

    @Override
    public void modifier_NOTE(Long id, Note updatedNote) {
        validateNoteValue(updatedNote.getNote()); // Validate note before updating
        Note n = noteRepo.findById(id).orElseThrow(() -> new RuntimeException("Note not found")); // Handle not found case
        n.setType(updatedNote.getType());
        n.setNote(updatedNote.getNote());
        n.setMatiere(updatedNote.getMatiere());
        n.setEtudiant(updatedNote.getEtudiant());
        noteRepo.save(n);
    }

    @Override
    public List<Note> afficher_Note_ETDMATIERE(Long idEtd, Long idClasse) {
        return noteRepo.findByEtdMatiere(idEtd, idClasse);
    }

    @Override
    public List<Note> NotesByEtd(Long idEtd) {
        return noteRepo.findByEtd(idEtd);
    }

    @Override
    public List<Note> findByClasse(Long idClasse) {
        return noteRepo.findByClasse(idClasse);
    }

    @Override
    public void addEtudiant(Long idNote, Long idEtd) {
        Note n = noteRepo.findById(idNote).orElseThrow(() -> new RuntimeException("Note not found")); // Handle not found case
        Etudiant etd = etdRepo.findById(idEtd).orElseThrow(() -> new RuntimeException("Etudiant not found")); // Handle not found case
        n.setEtudiant(etd);
        noteRepo.save(n);
    }

    @Override
    public void addMatiere(Long idNote, Long idMat) {
        Note n = noteRepo.findById(idNote).orElseThrow(() -> new RuntimeException("Note not found")); // Handle not found case
        Matiere m = matRepo.findById(idMat).orElseThrow(() -> new RuntimeException("Matiere not found")); // Handle not found case
        n.setMatiere(m);
        noteRepo.save(n);
    }

    // Validation method for notes
    private void validateNoteValue(Float noteValue) {
        if (noteValue < 0 || noteValue > 20 || (noteValue * 100) % 25 != 0) {
            throw new IllegalArgumentException("Note must be between 0 and 20 and in increments of 0.25.");
        }
    }
}
