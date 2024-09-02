package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
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

    @DisplayName("Value source test")
    @ParameterizedTest(name = "{displayName} - {index}: {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val){
        System.out.println(val);
    }

    @DisplayName("Value source test")
    @ParameterizedTest(name = "{displayName} - {index}: {arguments}")
    @EnumSource(OwnerType.class)
    void enumTests(OwnerType ownerType){
        System.out.println(ownerType);
    }

    @DisplayName("CSV Input test")
    @ParameterizedTest(name = "{displayName} - {index}: {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 3, 3",
    })
    void csvInputTest(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("CSV From file test")
    @ParameterizedTest(name = "{displayName} - {index}: {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFileTest(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }
}