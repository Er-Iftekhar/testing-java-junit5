package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class PersonTest {

    @Test
    void groupedAssertions(){
        // given
        Person person =  new Person(1L, "Joe", "Buck");
        //then
        assertAll("Test properties set",
                ()-> assertEquals("Joe", person.getFirstName()),
                ()-> assertEquals("Buck", person.getLastName()));
    }

    @Test
    void groupedAssertionsWithMessages(){
        // given
        Person person =  new Person(1L, "Joe", "Buck");
        //then
        assertAll("Test properties set",
                ()-> assertEquals("Joe", person.getFirstName(), "First name is wrong"),
                ()-> assertEquals("Buck", person.getLastName(), "Last name is wrong"));
    }
}