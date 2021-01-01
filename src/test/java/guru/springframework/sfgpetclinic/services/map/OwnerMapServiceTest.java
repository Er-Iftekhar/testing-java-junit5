package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    PetTypeService petTypeService;
    PetService petService;
    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);
    }

    @Test
    public void whenOwnerMapSizeIsZero_thenCorrect(){
        assertEquals(0, ownerMapService.findAll().size());
    }

    @DisplayName("Testing the create Owners")
    @Nested
    class CreatePetType{

        @BeforeEach
        public void setUp(){
            PetType petType1 = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");
            petTypeService.save(petType1);
            petTypeService.save(petType2);
        }

        @Test
        public void whenPetCountGreaterThanZero_thenCorrect(){
            int petTypeCount = petTypeService.findAll().size();
            assertThat(petTypeCount).isNotZero().isEqualTo(2);
        }


        @DisplayName("Save Owners Tests")
        @Nested
        class SaveOwnerTest{

            @BeforeEach
            void setUp(){
                Owner owner1 = new Owner(1L, "Yasar", "Iftekhar");
                ownerMapService.save(owner1);
            }


            @Test
            void whenOwnersMapIsNotZero_thenCorrect(){
                Owner owner2 = new Owner(2L, "sathya1", "sathya2");
                Owner savedOwner = ownerMapService.save(owner2);
                assertThat(savedOwner).isNotNull();
            }


            @DisplayName("Find owners tests")
            @Nested
            class FindOwnersTests{

                @Test
                public void whenFoundOwnerById_thenCorrect(){
                    Owner ownerFoundById = ownerMapService.findById(1L);
                    assertThat(ownerFoundById).isNotNull();
                }

                @DisplayName("Find Owner not found")
                @Test
                public void findOwnerNotFound(){
                    Owner ownerFoundById = ownerMapService.findById(2L);
                    assertThat(ownerFoundById).isNull();
                }
            }
        }
    }

    @DisplayName("Verify Still Zero Owners")
    @Test
    public void ownersStillZero(){
        int ownerMapCount = ownerMapService.findAll().size();
        assertThat(ownerMapCount).isZero();
    }
}