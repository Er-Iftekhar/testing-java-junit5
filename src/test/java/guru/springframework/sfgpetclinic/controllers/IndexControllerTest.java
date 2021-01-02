package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllersTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

//@Tag("controllers") Not needed as we are implementing the interface controller tests
//@DisplayName("Test for IndexController")
class IndexControllerTest  implements ControllersTests {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test Proper view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Not so expensive method");
        assertEquals("index", indexController.index(), ()-> "Some  expensive method" +
                "For display a failed execution");

        assertThat(indexController.index()).isEqualTo("index");

    }

    @Test
    @DisplayName("Test exception")
    void oopsHandler() {

        assertThrows(ValueNotFoundException.class, ()-> {
            indexController.oopsHandler();
        });

        /*Before implementing the exception throwing test
        assertTrue("notimplemented".equals(indexController.oopsHandler()));
        assertEquals("notimplemented", indexController.oopsHandler(), "Not so expensive method");
        assertEquals("notimplemented", indexController.oopsHandler(), ()-> "Some  expensive method" +
                "For display a failed execution");*/
    }

    @Disabled("Demo for timeout")
    @Test
    public void whenThrowsExceptionAfterTimeout_thenCorrect(){
        assertTimeout(Duration.ofMillis(200),
                ()-> Thread.sleep(2000));
    }

    @Disabled("Demo for timeout preemptively")
    @Test
    public void testTimeoutPreemptively(){
        assertTimeoutPreemptively(Duration.ofMillis(200),
                ()-> Thread.sleep(5));
    }


    @Test
    public void testAssumption(){
        assumeTrue("Yasar".equalsIgnoreCase(System.getenv("YASAR_RUNTIME")));
    }

    @Test
    public  void testAssumptionsWhenTrue(){
        assumeTrue("Yasar".equalsIgnoreCase("Yasar"));
    }


    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testOnWindows(){

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    public void testOnLinux(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void testOnJava8(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    public void testOnJava11(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "syedy")
    public void testIfUserSyedy(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "guru")
    public void testIfUserGuru(){

    }
}