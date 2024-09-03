package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.junitextensions.TimingExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TimingExtension.class)
public class PetTypeSDJpsServiceIT {

    @BeforeEach
    void beforeEachTest(){
        System.out.println("Before all test");
    }

    @Test
    void findAll(){
        System.out.println("findAll() from the service class");
    }

}
