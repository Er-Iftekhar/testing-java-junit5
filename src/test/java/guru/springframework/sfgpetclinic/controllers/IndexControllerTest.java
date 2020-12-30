package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Not so expensive method");
        assertEquals("index", indexController.index(), ()-> "Some  expensive method" +
                "For display a failed execution");

    }

    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()));
        assertEquals("notimplemented", indexController.oupsHandler(), "Not so expensive method");
        assertEquals("notimplemented", indexController.oupsHandler(), ()-> "Some  expensive method" +
                "For display a failed execution");
    }
}