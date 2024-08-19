package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Disabled until mocking is learnt")
class OwnerSDJpaServiceTest {

    OwnerService ownerService;
    @BeforeEach
    void setUp() {
        ownerService = new OwnerSDJpaService(null, null, null);
    }

    @Test
    void findByLastName() {
        ownerService.findByLastName("someLastName");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}