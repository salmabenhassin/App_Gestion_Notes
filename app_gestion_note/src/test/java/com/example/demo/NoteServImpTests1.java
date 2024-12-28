package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Note;
import com.example.demo.repository.IEtudiantRepository;
import com.example.demo.repository.IMatiereRepository;
import com.example.demo.repository.INoteRepository;
import com.example.demo.services.NoteServImp;

@ExtendWith(MockitoExtension.class)
public class NoteServImpTests1 {

    @Mock
    private INoteRepository noteRepository;

    @Mock
    private IEtudiantRepository etudiantRepository;

    @Mock
    private IMatiereRepository matiereRepository;

    @InjectMocks
    private NoteServImp noteService;
    
    
    
 // Test Case TC-008: Ajouter des notes avec des données valides
    @Test
    public void testAjouterNoteValide() {
        Note note = new Note();
        note.setId(1L);
        note.setNote(15.0f); // valid note within range
        when(noteRepository.save(note)).thenReturn(note);

        Note savedNote = noteService.ajouter_NOTE(note);

        assertNotNull(savedNote);
        assertEquals(15.0f, savedNote.getNote());
    }

    // Test Case TC-009: Ajouter des notes avec des données invalides (hors limites)
    @Test
    public void testAjouterNoteInvalide() {
        Note note = new Note();
        note.setId(2L);
        note.setNote(110.0f); // invalid note (greater than 20)
        
        assertThrows(IllegalArgumentException.class, () -> noteService.ajouter_NOTE(note));
    }

    // Test Case TC-010: Modification des notes avec des valeurs valides
    @Test
    public void testModifierNoteValide() {
        Note existingNote = new Note();
        existingNote.setId(1L);
        existingNote.setNote(10.0f); // existing valid note
        when(noteRepository.findById(1L)).thenReturn(Optional.of(existingNote));

        Note updatedNote = new Note();
        updatedNote.setNote(15.0f); // valid updated note

        noteService.modifier_NOTE(1L, updatedNote);

        assertEquals(15.0f, existingNote.getNote()); // Check if the note was updated
    }

    // Test Case TC-011: Modification des notes avec des valeurs invalides (hors limites)
    /*@Test
    public void testModifierNoteInvalide() {
        Note existingNote = new Note();
        existingNote.setId(1L);
        existingNote.setNote(10.0f); // existing valid note
        when(noteRepository.findById(1L)).thenReturn(Optional.of(existingNote));

        Note updatedNote = new Note();
        updatedNote.setNote(110.0f); // invalid note (greater than 20)
        
        assertThrows(IllegalArgumentException.class, () -> noteService.modifier_NOTE(1L, updatedNote));
    }
    */
    

    
    /*
    @Test
    public void testAjouterNote() {
        Note note = new Note();
        note.setId(1L);
        when(noteRepository.save(note)).thenReturn(note);

        Note savedNote = noteService.ajouter_NOTE(note);

        assertNotNull(savedNote);
        assertEquals(1L, savedNote.getId());
    }

    @Test
    public void testAddListNotes() {
        Note note1 = new Note();
        note1.setId(1L);
        Note note2 = new Note();
        note2.setId(2L);
        List<Note> notes = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);

        when(noteRepository.saveAll(notes)).thenReturn(notes);

        List<Note> savedNotes = noteService.addlistNotes(notes);

        assertNotNull(savedNotes);
        assertEquals(2, savedNotes.size());
    }

    @Test
    public void testChercherNote() {
        Note note = new Note();
        note.setId(1L);
        Optional<Note> optionalNote = Optional.of(note);
        when(noteRepository.findById(anyLong())).thenReturn(optionalNote);

        Note retrievedNote = noteService.chercher_Note(1L);

        assertNotNull(retrievedNote);
        assertEquals(1L, retrievedNote.getId());
    }

    // Ajoutez des tests pour les autres méthodes de service comme modifier_NOTE, supprimer_NOTE, etc.
     */
}

