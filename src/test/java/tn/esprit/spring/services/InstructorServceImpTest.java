package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import tn.esprit.spring.entities.Instructor;

import java.util.List;
@SpringBootTest
@SpringJUnitConfig
public class InstructorServceImpTest {
    @Autowired
    IInstructorServices us;
    @Test
    @Order(1)
    public void testRetrieveAllInstructors() {
        // Perform any setup you might need, such as saving test users to the database
        List<Instructor> instructorList=us.retrieveAllInstructors();

        // Make your assertions based on the test data you've set up
        Assertions.assertEquals(0, instructorList.size());
        // Add additional assertions as needed
    }
}