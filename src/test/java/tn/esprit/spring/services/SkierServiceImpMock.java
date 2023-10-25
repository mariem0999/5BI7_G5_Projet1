package tn.esprit.spring.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.entities.Registration;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.entities.Skier;

import java.time.LocalDate;
import java.util.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class SkierServiceImpMock {
    @Mock
    ISkierRepository   skierRepository;
    @InjectMocks
     ISkierServices skierServices;
    Set<Piste> pistes = new HashSet<>();
    Set<Registration> registrations = new HashSet<>();


    Skier skier = new Skier( 1L,"fray","mhamed", LocalDate.of(2020, 5, 15),"nabeul", pistes,registrations);
    List<Skier> skierList = new ArrayList<Skier>() {
        {
            add(new Skier(12L,"fray1","mhamed1", LocalDate.of(2021, 6, 16),"nabeul1", pistes,registrations));
            add(new Skier(13L,"fray2","mhamed2", LocalDate.of(2023, 7, 17),"nabeul2", pistes,registrations));
        }
    };
    @Test
    public void retrieveSkier (){
        Mockito.when(skierRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(skier));
        Skier skier1 = skierServices.retrieveSkier(Long.valueOf("1L"));
        Assertions.assertNotNull(skier1);
    }
}
