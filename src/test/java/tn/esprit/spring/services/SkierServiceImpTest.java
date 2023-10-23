package tn.esprit.spring.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import tn.esprit.spring.entities.Skier;

import java.util.List;

@SpringBootTest
@SpringJUnitConfig
public class SkierServiceImpTest {

    @Autowired
    ISkierServices sk ;
    @Test
    @Order(1)
    public void testRetrieveAllSkiers(){
        List<Skier> skierList = sk.retrieveAllSkiers();

        // Make your assertions based on the test data you've set up
        Assertions.assertEquals(0, skierList.size());
    }
}
