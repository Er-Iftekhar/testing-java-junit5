package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("repeatedTests")
public interface RepeatedModelTests {

    @BeforeEach
    default void testRepeatedConsoleOutput(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition() + " - " + repetitionInfo.getTotalRepetitions());
    }
}
