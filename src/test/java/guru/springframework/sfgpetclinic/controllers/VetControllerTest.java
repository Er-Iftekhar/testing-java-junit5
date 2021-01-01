package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    VetController vetController;
    VetService vetService;
    final String  VIEW_NAME = "vets/index";
    ModelMapImpl model = new ModelMapImpl();


    @BeforeEach
    void setUp() {
        vetService = new VetMapService(new SpecialityMapService());
        vetController = new VetController(vetService);

        Set<Speciality> specialities = new HashSet<>();
        specialities.add(new Speciality(1L, "Surgeon"));
        specialities.add(new Speciality(1L, "Pharmacologist"));

        Vet vet1 = new Vet(1L, "firstName1", "lastName1", specialities);
        Vet vet2 = new Vet(2L, "firstName2", "lastName2", specialities);
        vetService.save(vet1);
        vetService.save(vet2);

        model = new ModelMapImpl();
    }

    @Test
    void listVets() {

        String viewNameReturned = vetController.listVets(model);

        Map<String, Object> map = model.getMap();

        Set vets = (Set)model.getMap().get("vets");
        System.out.println(vets.size());
        assertEquals(VIEW_NAME, vetController.listVets(model));
        assertEquals( vetService.findAll().size(), vets.size());


    }
}