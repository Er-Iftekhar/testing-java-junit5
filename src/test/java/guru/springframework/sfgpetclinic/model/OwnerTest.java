package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {
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
        assertThat(owner.getCity(), is("Key West"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val){
        System.out.println(val);
    }
}