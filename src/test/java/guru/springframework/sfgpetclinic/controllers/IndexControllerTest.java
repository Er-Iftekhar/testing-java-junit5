package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("indexd", controller.index(), ()->"Another expensive message"+
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
}