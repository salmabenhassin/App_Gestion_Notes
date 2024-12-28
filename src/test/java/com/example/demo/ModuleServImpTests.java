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
import com.example.demo.entities.Module;
import com.example.demo.repository.IClasseRepository;
import com.example.demo.repository.IMatiereRepository;
import com.example.demo.repository.IModuleRepository;
import com.example.demo.services.ModuleServImp;

@ExtendWith(MockitoExtension.class)
public class ModuleServImpTests {

    @Mock
    private IModuleRepository moduleRepository;

    @Mock
    private IClasseRepository classeRepository;

    @Mock
    private IMatiereRepository matiereRepository;

    @InjectMocks
    private ModuleServImp moduleService;

    @Test
    public void testAddModule() {
        Module module = new Module();
        module.setIdModule(1L);
        when(moduleRepository.save(module)).thenReturn(module);

        Module savedModule = moduleService.addModule(module);

        assertNotNull(savedModule);
        assertEquals(1L, savedModule.getIdModule());
    }

    @Test
    public void testAddListModules() {
        Module module1 = new Module();
        module1.setIdModule(1L);
        Module module2 = new Module();
        module2.setIdModule(2L);
        List<Module> modules = new ArrayList<>();
        modules.add(module1);
        modules.add(module2);

        when(moduleRepository.saveAll(modules)).thenReturn(modules);

        List<Module> savedModules = moduleService.addlistmodules(modules);

        assertNotNull(savedModules);
        assertEquals(2, savedModules.size());
    }

    @Test
    public void testGetModuleById() {
        Module module = new Module();
        module.setIdModule(1L);
        Optional<Module> optionalModule = Optional.of(module);
        when(moduleRepository.findById(anyLong())).thenReturn(optionalModule);

        Module retrievedModule = moduleService.getmodulebyid(1L);

        assertNotNull(retrievedModule);
        assertEquals(1L, retrievedModule.getIdModule());
    }

    // Ajoutez des tests pour les autres méthodes de service comme UpdateModule, DeleteModule, etc.
}
