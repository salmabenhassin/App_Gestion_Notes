package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import com.example.demo.entities.Classe;
import com.example.demo.entities.Specialite;
import com.example.demo.repository.IClasseRepository;
import com.example.demo.repository.ISpecialiteRepository;
import com.example.demo.services.SpecServImp;

@ExtendWith(MockitoExtension.class)
public class SpecServImpTests {

    @Mock
    private ISpecialiteRepository specialiteRepository;

    @Mock
    private IClasseRepository classeRepository;

    @InjectMocks
    private SpecServImp specialiteService;

    @Test
    public void testAddSpecialite() {
        Specialite specialite = new Specialite();
        specialite.setIdSpecialite(1L);
        when(specialiteRepository.save(specialite)).thenReturn(specialite);

        Specialite savedSpecialite = specialiteService.addSpecialite(specialite);

        assertNotNull(savedSpecialite);
        assertEquals(1L, savedSpecialite.getIdSpecialite());
    }

    @Test
    public void testAddListSpecialite() {
        Specialite specialite1 = new Specialite();
        specialite1.setIdSpecialite(1L);
        Specialite specialite2 = new Specialite();
        specialite2.setIdSpecialite(2L);
        List<Specialite> specialites = new ArrayList<>();
        specialites.add(specialite1);
        specialites.add(specialite2);

        when(specialiteRepository.saveAll(specialites)).thenReturn(specialites);

        List<Specialite> savedSpecialites = specialiteService.addlistspecialite(specialites);

        assertNotNull(savedSpecialites);
        assertEquals(2, savedSpecialites.size());
    }

    @Test
    public void testGetSpecialiteById() {
        Specialite specialite = new Specialite();
        specialite.setIdSpecialite(1L);
        Optional<Specialite> optionalSpecialite = Optional.of(specialite);
        when(specialiteRepository.findById(anyLong())).thenReturn(optionalSpecialite);

        Specialite retrievedSpecialite = specialiteService.getSpecialitebyid(1L);

        assertNotNull(retrievedSpecialite);
        assertEquals(1L, retrievedSpecialite.getIdSpecialite());
    }

    // Ajoutez des tests pour les autres méthodes de service comme UpdateSpecialite, DeleteSpecialite, etc.
}

