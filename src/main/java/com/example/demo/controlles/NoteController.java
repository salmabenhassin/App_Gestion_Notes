package com.example.demo.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Note;
import com.example.demo.services.INoteServ;
import com.example.demo.services.NoteServImp;

@RestController
public class NoteController {
    @Autowired
    private NoteServImp noteServ;

    @PostMapping(value = "/addNote")
    public Note addNote(@RequestBody Note note) {
        return noteServ.ajouter_NOTE(note);
    }

    @PostMapping(value = "/addListNotes")
    public List<Note> addListNotes(@RequestBody List<Note> notes){
        return noteServ.addlistNotes(notes);
    }

    @GetMapping(value = "/getNote/{id}")
    public Note getNote(@PathVariable("id") Long id) {
        return noteServ.chercher_Note(id);
    }

    @DeleteMapping(value = "/deleteNote/{id}")
    public void deleteNote(@PathVariable("id") Long id) {
        noteServ.supprimer_NOTE(id);
    }

    @GetMapping(value = "/getAllNotes")
    public List<Note> getAllNotes() {
        return noteServ.afficher_NOTE();
    }

    @PutMapping(value = "/updateNote/{id}")
    public void updateNote(@PathVariable("id") Long id, @RequestBody Note updatedNote) {
        noteServ.modifier_NOTE(id, updatedNote);
    }

    @GetMapping(value = "/getNotesByEtudiantAndMatiere/{idEtd}/{idMatiere}")
    public List<Note> getNotesByEtudiantAndMatiere(@PathVariable("idEtd") Long idEtd, @PathVariable("idMatiere") Long idMatiere) {
        return noteServ.afficher_Note_ETDMATIERE(idEtd, idMatiere);
    }
    @GetMapping(value = "/getNotesByEtudiant/{idEtd}")
    public List<Note> getNotesByEtudiantAndMatiere(@PathVariable("idEtd") Long idEtd) {
        return noteServ.NotesByEtd(idEtd);
    }
    @GetMapping(value = "/getNotesByClasse/{idClasse}")
    public List<Note> getNotesByClasse(@PathVariable("idClasse") Long idClasse) {
        return noteServ.findByClasse(idClasse);
    }
    @PutMapping(value = "/addEtudiantToNote/{idNote}/{idEtd}")
    public void addEtudiant(@PathVariable("idNote") Long idNote, @PathVariable("idEtd") Long idEtd) {
        noteServ.addEtudiant(idNote, idEtd);
    }
    @PutMapping(value = "/addMatiereToNote/{idNote}/{idMat}")
    public void addMatiere(@PathVariable("idNote") Long idNote, @PathVariable("idMat") Long idMat) {
        noteServ.addMatiere(idNote, idMat);
    }
}