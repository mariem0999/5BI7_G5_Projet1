package src.test.java.tn.esprit.spring.services;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import src.main.java.tn.esprit.spring.entities.*;
import src.main.java.tn.esprit.spring.repositories.*;
import src.main.java.tn.esprit.spring.services.PisteServicesImpl;
import tn.esprit.spring.entities.Piste;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PisteTest {
    @InjectMocks
    PisteServicesImpl PisteService ;

    @Mock
    IPisteRepository PisteRepository ;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllPistes () {
        List<Piste> expectedPistes = new ArrayList<>() ;
        expectedPistes.add(new Piste(1L, "piste1", null, 100, 30)) ;
        expectedPistes.add(new Piste(2L, "piste2", null, 100, 30)) ;

        when(PisteRepository.findAll()).thenReturn(expectedPistes);
        List<Piste> result = PisteService.retrieveAllPiste();
        assertIterableEquals(expectedPistes, result);
    }

    @Test
    public void testAddPistes () {
        Piste PisteToSave = new Piste(1L, "piste1", null, 100, 30);
        when(PisteRepository.save(PisteToSave)).thenReturn(PisteToSave) ;
        Piste result = PisteService.addPiste(PisteToSave) ;
        assertEquals(PisteToSave,result);
    }

    @Test
    public void testDeletePiste () {
        Long idPisteToDelete = 1L ;
        PisteService.deletePiste(idPisteToDelete);
        verify(PisteRepository).deleteById(idPisteToDelete);
    }

    @Test
    public void testUpdatePiste() {
        Piste PisteToUpdate = new Piste(1L, "piste1", null, 100, 30);
        when(PisteRepository.save(PisteToUpdate)).thenReturn(PisteToUpdate);
        Piste result = PisteService.updatePiste(PisteToUpdate);
        assertEquals(PisteToUpdate, result);
    }

    @Test
    public void testRetrievePiste() {
        Long PisteIdToRetrieve = 1L;
        Piste expectedPiste = new Piste(1L, "piste1", null, 100, 30);
        when(PisteRepository.findById(PisteIdToRetrieve)).thenReturn(java.util.Optional.ofNullable(expectedPiste));
        Piste result = PisteService.retrievePiste(PisteIdToRetrieve);
        assertEquals(expectedPiste, result);
    }



}
