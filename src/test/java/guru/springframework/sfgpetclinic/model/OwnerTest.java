package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    public void whenPropertiesOfBothOwnerAndPersonAreValid_thenCorrect(){
        Owner owner = new Owner(1L, "Yasar", "Iftekhar");
        owner.setCity("Prague");
        owner.setTelephone("124563");

        assertAll("Testing Properties of Person and Owner objects",
                ()->assertAll("Person properties test",
                        ()-> assertEquals("Yasar", owner.getFirstName(),
                                "Persons first name did not match"),
                        ()-> assertEquals("Iftekhar", owner.getLastName())),
                ()-> assertAll("Owner properties test",
                        ()-> assertEquals("Prague", owner.getCity(),
                                "Owners city name did not match"),
                        ()-> assertEquals("124563", owner.getTelephone())));
    }
}