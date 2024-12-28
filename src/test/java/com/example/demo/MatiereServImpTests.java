package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
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
import com.example.demo.entities.Matiere;
import com.example.demo.entities.Note;
import com.example.demo.repository.IMatiereRepository;
import com.example.demo.repository.IModuleRepository;
import com.example.demo.repository.INoteRepository;
import com.example.demo.services.MatiereservImp;

@ExtendWith(MockitoExtension.class)
public class MatiereServImpTests {
    @Mock
    private IMatiereRepository matiereRepository;
    @Mock
    private IModuleRepository moduleRepository;
    @Mock
    private INoteRepository noteRepository;
    @InjectMocks
    private MatiereservImp matiereService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddMatiere() {
        Matiere matiere = new Matiere();
        matiere.setIdMatiere(1L);
        matiere.setNomMatiere("Math");
        matiere.setCoifMatiere(3);
        when(matiereRepository.save(matiere)).thenReturn(matiere);
        Matiere savedMatiere = matiereService.addMatiere(matiere);
        assertNotNull(savedMatiere);
        assertEquals(1L, savedMatiere.getIdMatiere());
        assertEquals("Math", savedMatiere.getNomMatiere());
        assertEquals(3, savedMatiere.getCoifMatiere());
    }
    @Test
    public void testGetMatiereById() {
        Matiere matiere = new Matiere();
        matiere.setIdMatiere(1L);
        Optional<Matiere> optionalMatiere = Optional.of(matiere);
        when(matiereRepository.findById(1L)).thenReturn(optionalMatiere);
        Matiere retrievedMatiere = matiereService.getmatierebyid(1L);
        assertNotNull(retrievedMatiere);
        assertEquals(1L, retrievedMatiere.getIdMatiere());
    }
  
    @Test
    public void testGetAllMatieres() {
        List<Matiere> matieres = new ArrayList<>();
        matieres.add(new Matiere());
        matieres.add(new Matiere());
        when(matiereRepository.findAll()).thenReturn(matieres);
        List<Matiere> retrievedMatieres = matiereService.getAllMatieres();
        assertNotNull(retrievedMatieres);
        assertEquals(2, retrievedMatieres.size());
    }
    // Ajoutez des tests pour les autres méthodes ici...
}

