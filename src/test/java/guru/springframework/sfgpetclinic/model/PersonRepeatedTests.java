package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.RepeatedModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTests implements RepeatedModelTests {

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("Method Repetition Test")
    public void whenTestRepeats_thenCorrect(){
        //todo impl

    }


    @RepeatedTest(5)
    @DisplayName("RepeatedTests using DI")
    public void repeatedTestsUsingDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(2)
    @DisplayName("Assignment Repeated tests")
    public void repeatedTestAssignment(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition()+" - "+repetitionInfo.getTotalRepetitions());
    }
}
