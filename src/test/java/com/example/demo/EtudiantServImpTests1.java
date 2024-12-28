package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.demo.entities.Classe;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Note;
import com.example.demo.repository.IClasseRepository;
import com.example.demo.repository.IEtudiantRepository;
import com.example.demo.repository.INoteRepository;
import com.example.demo.services.EtudiantServImp;
@ExtendWith(MockitoExtension.class)
public class EtudiantServImpTests1 {
    @Mock
    private IEtudiantRepository etudiantRepository;
    @Mock
    private IClasseRepository classeRepository;
    @Mock
    private INoteRepository noteRepository;
    @InjectMocks
    private EtudiantServImp etudiantService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    
    //TC01
    @Test
    public void testAjouterETD_ValidStudent() {
        // Arrange: Create a valid Etudiant object
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("Doe");
        etudiant.setPrenom("John");
        etudiant.setEmail("john.doe@example.com");
        etudiant.setCin(12345678);
        etudiant.setAdresse("1234 Elm Street");
        etudiant.setTel(1234567890);

        // Mock the save method of the repository
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(etudiant);

        // Act: Call the method to add the student
        Etudiant createdEtudiant = etudiantService.ajouter_ETD(etudiant);

        // Assert: Verify that the student is created successfully
        assertNotNull(createdEtudiant, "The student should be created successfully.");
        assertEquals("Doe", createdEtudiant.getNom(), "The student's last name should match.");
        assertEquals("John", createdEtudiant.getPrenom(), "The student's first name should match.");
        assertEquals("john.doe@example.com", createdEtudiant.getEmail(), "The student's email should match.");
        
        // Verify the save method was called once
        verify(etudiantRepository, times(1)).save(etudiant);
    }

    /*
    //TC02
    @Test
    public void testAjouterETD_InvalidEmail() {
        // Arrange: Create a student with an invalid email
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("Doe");
        etudiant.setPrenom("John");
        etudiant.setEmail("abc@@gmail.com");  // Invalid email format
        etudiant.setCin(12345678);
        etudiant.setAdresse("1234 Elm Street");
        etudiant.setTel(1234567890);

        // Act and Assert: Call the method and assert an exception is thrown
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            etudiantService.ajouter_ETD(etudiant);
        });

        // Assert: Check the error message
        assertEquals("Invalid email format", exception.getMessage(), "The error message should indicate invalid email.");
    }
    */
    
    //TC03
    /* @Test
    public void testAjouterETD_EmptyRequiredFields() {
        // Arrange: Create a student with empty required fields
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("");  // Empty name (required field)
        etudiant.setPrenom("John");
        etudiant.setEmail("john.doe@example.com");
        etudiant.setCin(12345678);
        etudiant.setAdresse("1234 Elm Street");
        etudiant.setTel(1234567890);

        // Act and Assert: Call the method and assert an exception is thrown
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            etudiantService.ajouter_ETD(etudiant);
        });

        // Assert: Check the error message
        assertEquals("Required fields cannot be empty", exception.getMessage(), "The error message should indicate empty required fields.");
    }
    */
    
    //TC04
    /*
    @Test
    public void testModifierETD_ValidModification() {
        // Arrange: Create a student and an updated student object
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1L);
        etudiant.setNom("Doe");
        etudiant.setPrenom("John");
        etudiant.setEmail("john.doe@example.com");

        Etudiant updatedEtudiant = new Etudiant();
        updatedEtudiant.setNom("Updated Doe");
        updatedEtudiant.setPrenom("Updated John");
        updatedEtudiant.setEmail("updated.john@example.com");

        // Mock repository methods
        when(etudiantRepository.findById(1L)).thenReturn(Optional.of(etudiant));
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(updatedEtudiant);

        // Act: Call the method to modify the student
        etudiantService.modifier_ETD(1L, updatedEtudiant);

        // Assert: Verify the student's information is updated
        assertEquals("Updated Doe", updatedEtudiant.getNom(), "The student's last name should be updated.");
        assertEquals("Updated John", updatedEtudiant.getPrenom(), "The student's first name should be updated.");
        assertEquals("updated.john@example.com", updatedEtudiant.getEmail(), "The student's email should be updated.");

        // Verify the save method was called once
        verify(etudiantRepository, times(1)).save(updatedEtudiant);
    }
    */

    /*
    //TC05
    @Test
    void testModifierETD_ExistingEmail_ThrowsException() {
        // Arrange: Create an updated Etudiant object with an email that already exists
        Etudiant updatedEtudiant = new Etudiant();
        updatedEtudiant.setId(1L);  // Assume this student ID exists
        updatedEtudiant.setEmail("existing@example.com");  // Email that already exists in another Etudiant
        updatedEtudiant.setNom("Updated Name");
        updatedEtudiant.setPrenom("Updated Prenom");
        updatedEtudiant.setCin(12345);
        updatedEtudiant.setLieun("City");
        updatedEtudiant.setAdresse("Address");
        updatedEtudiant.setTel(987654321);

        // Create an existing Etudiant with a different ID but the same email
        Etudiant existingEtudiant = new Etudiant();
        existingEtudiant.setEmail("existing@example.com");
        existingEtudiant.setId(2L);  // Different ID but same email
        existingEtudiant.setNom("Another Name");
        existingEtudiant.setPrenom("Another Prenom");
        existingEtudiant.setCin(67890);
        existingEtudiant.setLieun("Another City");
        existingEtudiant.setAdresse("Another Address");
        existingEtudiant.setTel(123456789);

        // Mock the repository to return the existing Etudiant with the same email
        when(etudiantRepository.findByEmail(updatedEtudiant.getEmail())).thenReturn(Optional.of(existingEtudiant));

        // Act & Assert: Expect IllegalArgumentException to be thrown when attempting to update with an existing email
        assertThrows(IllegalArgumentException.class, () -> {
            etudiantService.modifier_ETD(updatedEtudiant.getId(), updatedEtudiant);
        });
    }
    */


    
    //TC06
    /*@Test
    public void testSupprimerETD_StudentWithNotes() {
        // Arrange: Create a student with associated notes
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1L);
        etudiant.setNom("Doe");

        Note note = new Note();
        note.setId(1L);
        note.setEtudiant(etudiant);

        List<Note> notes = new ArrayList<>();
        notes.add(note);
        when(noteRepository.findByEtd(1L)).thenReturn(notes);
        when(etudiantRepository.findById(1L)).thenReturn(Optional.of(etudiant));

        // Act: Call the method to delete the student
        etudiantService.supprimer_ETD(1L);

        // Assert: Verify the notes are deleted
        verify(noteRepository, times(1)).deleteById(1L); // Verify the notes are deleted
        verify(etudiantRepository, times(1)).deleteById(1L); // Verify the student is deleted
    }
	*/

    //TC07
    /*
    @Test
    public void testSupprimerETD_StudentNotFound() {
        // Arrange: Attempt to delete a non-existent student
        Long nonExistentStudentId = 999L;
        when(etudiantRepository.findById(nonExistentStudentId)).thenReturn(Optional.empty());

        // Act and Assert: Call the method and assert an exception is thrown
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            etudiantService.supprimer_ETD(nonExistentStudentId);
        });

        // Assert: Check the error message
        assertEquals("Student with ID 999 not found.", exception.getMessage(), "The error message should indicate the student was not found.");
        verify(etudiantRepository, times(0)).deleteById(nonExistentStudentId);  // Verify that deletion did not occur
    }
    */

    
    
    
    /*
    @Test
    public void testAjouterEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1L);
        etudiant.setNom("John");
        etudiant.setPrenom("Doe");
        when(etudiantRepository.save(etudiant)).thenReturn(etudiant);
        Etudiant savedEtudiant = etudiantService.ajouter_ETD(etudiant);
        assertNotNull(savedEtudiant);
        assertEquals(1L, savedEtudiant.getId());
        assertEquals("John", savedEtudiant.getNom());
        assertEquals("Doe", savedEtudiant.getPrenom());
    }
    @Test
    public void testChercherEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1L);
        Optional<Etudiant> optionalEtudiant = Optional.of(etudiant);
        when(etudiantRepository.findById(1L)).thenReturn(optionalEtudiant);
        Etudiant retrievedEtudiant = etudiantService.chercher_ETD(1L);
        assertNotNull(retrievedEtudiant);
        assertEquals(1L, retrievedEtudiant.getId());
    }
    @Test
    public void testSupprimerEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1L);
        List<Note> notes = new ArrayList<>();
        when(noteRepository.findByEtd(1L)).thenReturn(notes);
        etudiantService.supprimer_ETD(1L);
        assertNull(etudiantService.chercher_ETD(1L));
    }
    @Test
    public void testAfficherEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant());
        etudiants.add(new Etudiant());
        when(etudiantRepository.findAll()).thenReturn(etudiants);
        List<Etudiant> retrievedEtudiants = etudiantService.afficher_ETD();
        assertNotNull(retrievedEtudiants);
        assertEquals(2, retrievedEtudiants.size());
    }
    // Ajoutez des tests pour les autres méthodes ici...
    
    */
}

