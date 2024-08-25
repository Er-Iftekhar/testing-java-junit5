package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import guru.springframework.sfgpetclinic.services.springdatajpa.SpecialitySDJpaService;
import guru.springframework.sfgpetclinic.services.springdatajpa.VetSDJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Tag("controller")
class VetControllerTest {

    VetController controller ;
    VetService service;
    @BeforeEach
    void setUp() {
        SpecialtyService specialtyService = new SpecialityMapService();
        service = new VetMapService(specialtyService);
        controller = new VetController(service);

        Vet vet1 = new Vet(1L, "joe", "buck", null);
        Vet vet2 = new Vet(2L, "jimmy", "smith", null);
        service.save(vet1);
        service.save(vet2);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();
        String view = controller.listVets(model);
        Set modelAttribute = (Set) ((ModelMapImpl)model).getMap().get("vets");
        assertEquals("vets/index", view);
        assertEquals(modelAttribute.size(), 2);
    }
}