package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.repositories.IInstructorRepository;

import java.time.LocalDate;
import java.util.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class InstructorServiceImpMock {
    @Mock
    IInstructorRepository instructorRepository;
    @InjectMocks
    InstructorServicesImpl instructorServices;
    Set<Course> courses = new HashSet<>();
    Instructor instructor=new Instructor(1L,"Mariem","Essghaier", LocalDate.of(2020, 5, 15),courses);
    List<Instructor>instructorList=new ArrayList<Instructor>(){
        {
            add(new Instructor(2L,"Mhamed","Fray", LocalDate.of(2020, 6, 16),courses));
            add(new Instructor(3L,"Lobna","Sakli", LocalDate.of(2020, 9, 19),courses));
        }

    };
    @Test
    public void retrieveInstructor(){
        Mockito.when(instructorRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(instructor));
        Instructor instructor1=instructorServices.retrieveInstructor(Long.valueOf("1L"));
        Assertions.assertNotNull(instructor1);

    }
}
