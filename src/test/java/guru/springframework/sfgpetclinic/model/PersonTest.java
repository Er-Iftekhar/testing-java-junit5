package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@Tag("model")
class PersonTest {

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