package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

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