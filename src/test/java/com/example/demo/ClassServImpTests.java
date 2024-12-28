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
import com.example.demo.entities.Classe;
import com.example.demo.entities.Module;
import com.example.demo.entities.Specialite;
import com.example.demo.repository.IClasseRepository;
import com.example.demo.repository.IEtudiantRepository;
import com.example.demo.repository.IModuleRepository;
import com.example.demo.repository.ISpecialiteRepository;
import com.example.demo.services.ClassServImp;
@ExtendWith(MockitoExtension.class)
public class ClassServImpTests {
    @Mock
    private IClasseRepository classeRepository;
    @Mock
    private IEtudiantRepository etudiantRepository;
    @Mock
    private IModuleRepository moduleRepository;
    @Mock
    private ISpecialiteRepository specialiteRepository;
    @InjectMocks
    private ClassServImp classService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddClasse() {
        Classe classe = new Classe();
        classe.setIdclasse(1L);
        classe.setNomClasse("Nom de la classe");
        classe.setNiveauClasse(1);
        when(classeRepository.save(classe)).thenReturn(classe);
        Classe savedClasse = classService.addClasse(classe);
        assertNotNull(savedClasse);
        assertEquals(1L, savedClasse.getIdclasse());
        assertEquals("Nom de la classe", savedClasse.getNomClasse());
        assertEquals(1, savedClasse.getNiveauClasse());
    }
    @Test
    public void testGetClasseById() {
        Classe classe = new Classe();
        classe.setIdclasse(1L);
        Optional<Classe> optionalClasse = Optional.of(classe);
        when(classeRepository.findById(1L)).thenReturn(optionalClasse);
        Classe retrievedClasse = classService.getclassebyid(1L);
        assertNotNull(retrievedClasse);
        assertEquals(1L, retrievedClasse.getIdclasse());
    }
    @Test
    public void testUpdateClasse() {
        Classe existingClasse = new Classe();
        existingClasse.setIdclasse(1L);
        existingClasse.setNomClasse("Nom de la classe");
        existingClasse.setNiveauClasse(1);
        Classe updatedClasse = new Classe();
        updatedClasse.setIdclasse(1L);
        updatedClasse.setNomClasse("Nouveau nom de la classe");
        updatedClasse.setNiveauClasse(2);
        when(classeRepository.findById(1L)).thenReturn(Optional.of(existingClasse));
        when(classeRepository.save(existingClasse)).thenReturn(updatedClasse);
        Classe result = classService.UpdateClasse(updatedClasse, 1L);
        assertNotNull(result);
        assertEquals("Nouveau nom de la classe", result.getNomClasse());
        assertEquals(2, result.getNiveauClasse());
    }
    @Test
    public void testDeleteClasse() {
        Classe classe = new Classe();
        classe.setIdclasse(1L);
        when(etudiantRepository.findByClasse(1L)).thenReturn(new ArrayList<>());
        when(moduleRepository.findByClasse(1L)).thenReturn(new ArrayList<>());
        when(specialiteRepository.findByClasse(1L)).thenReturn(new ArrayList<>());
        classService.DeleteClasse(1L);
        assertNull(classService.getclassebyid(1L));
    }
    @Test
    public void testGetAllClasses() {
        List<Classe> classes = new ArrayList<>();
        classes.add(new Classe());
        classes.add(new Classe());
        when(classeRepository.findAll()).thenReturn(classes);
        List<Classe> retrievedClasses = classService.getAllClasses();
        assertNotNull(retrievedClasses);
        assertEquals(2, retrievedClasses.size());
    }
}

