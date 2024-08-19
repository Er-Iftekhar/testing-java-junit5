package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {
    @Test
    void dependentAssertions(){
        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("12345678910");
        assertAll("Properties test",
                ()->assertAll("Person properties",
                        ()->assertEquals("Joe", owner.getFirstName(), "First name did not match"),
                        ()->assertEquals("Buck", owner.getLastName())
                ),
                ()->assertAll("Owner properties",
                        ()->assertEquals("Key West", owner.getCity(), "City name did not match"),
                        ()->assertEquals("12345678910", owner.getTelephone())
                )
        );

    }

}