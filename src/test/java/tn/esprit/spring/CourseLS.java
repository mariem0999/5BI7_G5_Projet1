package tn.esprit.spring;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.CourseServicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
@SpringBootTest
@Slf4j
@ExtendWith(MockitoExtension.class)
public class CourseLS {

  /*  @InjectMocks
    private CourseServicesImpl courseService;

    @Mock
    private ICourseRepository courseRepository;

    @Befor
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllCourses() {
        // Créez une liste factice de cours
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course());
        courseList.add(new Course());

        when(courseRepository.findAll()).thenReturn(courseList);

        List<Course> result = courseService.retrieveAllCourses();

        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testAddCourse() {
        Course course = new Course();

        when(courseRepository.save(course)).thenReturn(course);

        Course result = courseService.addCourse(course);

        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdateCourse() {
        Course course = new Course();

        when(courseRepository.save(course)).thenReturn(course);

        Course result = courseService.updateCourse(course);

        Assert.assertNotNull(result);
    }

    /*   @Test
       public void testDeleteCourse() {
           Long courseNum = 1L;

           courseService.retrieveCourse(courseNum);

           verify(courseRepository).deleteById(courseNum);
       }
   */
   /* @Test
    public void testRetrieveCourse() {
        Long courseNum = 1L;
        Course course = new Course();
        when(courseRepository.findById(courseNum)).thenReturn(Optional.of(course));

        Course result = courseService.retrieveCourse(courseNum);

        Assert.assertNotNull(result);
    }*/
}