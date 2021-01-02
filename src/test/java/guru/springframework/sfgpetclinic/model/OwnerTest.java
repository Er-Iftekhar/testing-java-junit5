package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@Tag("model") Not needed as we implement the interface
class OwnerTest implements ModelTests {

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


        assertThat(owner.getCity(), is("Prague"));
    }
}