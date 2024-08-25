package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import javax.validation.ValidationException;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    @DisplayName("Test proper view name returned for index page")
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned");
        assertEquals("index", controller.index(), ()->"Another expensive message"+
                    "Make me only if you need to");
    }

    @Test
    @DisplayName("Test proper exception is thrown")
    void oupsHandler() {
        assertThrows(ValidationException.class, ()->{
            controller.oopsHandler();
        });
    }
    @Disabled("Demo for timeout")
    @Test
    void testTimeout(){
        assertTimeout(Duration.ofMillis(100), ()->{
            Thread.sleep(5000);
        });
    }

    @Disabled("Demo for timeout")
    @Test
    void testTimeoutPreempt(){
        assertTimeoutPreemptively(Duration.ofMillis(100), ()->{
            Thread.sleep(5000);
        });
    }

    @Test
    void testAssumptionTrue(){
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue(){
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testOnMac(){
        System.out.println("OS is Mac");
    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void testOnLinux(){
        System.out.println("OS is Linux");
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindows(){
        System.out.println("OS is Windows");
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testOnJava8(){

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testOnJava11(){

    }

    @EnabledOnJre(JRE.OTHER)
    @Test
    void testOnJava17(){

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "iftikhar")
    @Test
    void testIfUserMe(){

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "yasar")
    @Test
    void testIfUserOthers(){

    }
}