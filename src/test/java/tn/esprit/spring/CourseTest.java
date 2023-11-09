package tn.esprit.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;

import java.util.List;

@SpringBootTest
@Slf4j
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseTest {
    @Autowired
    ICourseRepository courseRepository;

    static Course c=Course.builder().level(2).typeCourse(TypeCourse.INDIVIDUAL).support(Support.SKI).price((float)22.2).timeSlot(3).build();

    @Test
    @Order(0)
    public void testCourseCreation() {
        c=courseRepository.save(c);
        log.info("Ajout ==>", c);
        Assertions.assertNotNull(c.getNumCourse());
        Assertions.assertNotEquals(0,c.getNumCourse());
    }
    @Test
    @Order(1)
    public void testCourseModification() {
        c.setLevel(5);
        c=courseRepository.save(c);
        log.info("Modif ==>",c.toString());
        Assertions.assertNotEquals(2,c.getLevel());
        Assertions.assertSame(5,c.getLevel());
    }
    @Test
    @Order(2)
    public void testCourceListe() {
        List<Course> list =courseRepository.findAll();
        log.info("Liste ==>",list.size());
        Assertions.assertTrue(list.size()>0 );
    }
    @Test
    @Order(3)
    public void testCourseChercher() {
        log.info("cherche course avec ID ==>",c.getNumCourse());
        Course c1 = courseRepository.findById(c.getNumCourse()).get();
        Assertions.assertEquals(c1.getLevel(),c.getLevel());

    }
    @Test
    @Order(4)
    public void testCourseSupprimer() {
        courseRepository.delete(c);

    }
}
