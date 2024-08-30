package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    PetTypeService petTypeService;
    PetService petService;
    OwnerMapService ownerService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerService = new OwnerMapService(petTypeService, petService);
    }

    @Test
    @DisplayName("Verify zero owners")
    void ownersAreZero(){
        int ownersCount = ownerService.findAll().size();
        assertEquals(0, ownersCount);
    }

    @DisplayName("Pet Type ...")
    @Nested
    class TestCreatedPetType{
        @BeforeEach
        void setUp() {
            PetType petType1 = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");
            petTypeService.save(petType1);
            petTypeService.save(petType2);
        }

        @DisplayName("Test Pet counts")
        @Test
        void testPetCount(){
            int petTypeCount = petTypeService.findAll().size();
            assertEquals(2, petTypeCount);
        }

        @DisplayName("Save Owners Test -")
        @Nested
        class SaveOwnersTests{
            @BeforeEach
            void setUp() {
                Owner owner = new Owner(1L, "Before", "Each");
                Owner savedOwner = ownerService.save(owner);
                assertNotNull(savedOwner);
            }

            @DisplayName("Save Owner")
            @Test
            void saveOwner(){
                Owner owner = new Owner(2L, "Joe", "Buck");
                Owner savedOwner = ownerService.save(owner);
                assertNotNull(savedOwner);
            }

            @DisplayName("Saved Owners Test")
            @Nested
            class FindOwnersTest{
                @DisplayName("Find Owner")
                @Test
                void findOwner(){
                    Owner foundOwner = ownerService.findById(1L);
                    assertNotNull(foundOwner);
                }

                @DisplayName("Find Owner not found")
                @Test
                void findOwnerNotFount(){
                    Owner foundOwner = ownerService.findById(2L);
                    assertNull(foundOwner);
                }
            }
        }

        @DisplayName("Verify still zero Owners")
        @Test
        void ownersAreStillZero(){
            int ownersCount = ownerService.findAll().size();
            assertEquals(0, ownersCount);
        }
    }
}