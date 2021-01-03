package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomProviderClass;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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

    @DisplayName("value source test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val){
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name ="{displayName} - [{index}] {arguments}" )
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("CSV Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "IND, 1, 1",
            "AUS, 2, 1",
            "QAT, 1, 3",
    })
    void csvInputTest(String countryName, int val1, int val2){
        System.out.println(countryName + " - " + val1 + " : " + val2);
    }


    @DisplayName("CSV from file")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/csvtest.csv", numLinesToSkip = 1)
    void testCsvFromFile(String countryName, int val1, int val2){
        System.out.println(countryName + " - " + val1 + " : " + val2);
    }



    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void testMethodArgs(String countryName, int val1, int val2){
        System.out.println(countryName + " - " + val1 + " : " + val2);
    }

    static Stream<Arguments> getArgs(){
        return Stream.of(
                Arguments.of("IND", 3, 1),
                Arguments.of("AUS", 1, 6),
                Arguments.of("PAK", 5, 1)
        );
    }


    @DisplayName("Custom Provider cass")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomProviderClass.class)
    void testCustomProvider(String countryName, int val1, int val2){
        System.out.println(countryName + " - "+ val1 + " : " + val2);
    }


}