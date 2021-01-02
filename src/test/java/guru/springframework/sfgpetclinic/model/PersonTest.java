package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


//@Tag("model") Not needed as we are implementing the interface ModelTest
class PersonTest implements ModelTests {

    @Test
    public void whenAllGroupedAssertionsPass_thenCorrect(){
        //given
        Person person = new Person(1L, "Yasar", "Iftekhar");
        //then
        assertAll("Test Props Set",
                ()-> assertEquals("Yasar", person.getFirstName()),
                ()-> assertEquals("Iftekhar", person.getLastName())
        );
    }

    @Test
    public void whenAllGroupedAssertionsWithMessagesPass_thenCorrect(){
        //given
        Person person = new Person(1L, "Yasar", "Iftekhar");
        //then
        assertAll("Test Props Set",
                ()-> assertEquals("Yasar", person.getFirstName(), "First Name Failed"),
                ()-> assertEquals("Iftekhar", person.getLastName(), "Last name failed")
        );
    }

}