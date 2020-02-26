package guru.springframework.springpetclinic.services.map;

import guru.springframework.springpetclinic.model.Pet;
import guru.springframework.springpetclinic.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceMapTest {

    PetServiceMap petServiceMap;
    final Long petId = 1L;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        Pet pet = new Pet();
        petServiceMap.save(pet);
        pet.setId(1L);
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petServiceMap.findAll();

        assertEquals(1, petSet.size());
    }

    @Test
    void findById() {
        Pet pet = petServiceMap.findById(petId);

        assertEquals(petId, pet.getId());
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(petId);

        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(petId));

        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void save() {
        Pet pet = new Pet();
        Pet savedPet = petServiceMap.save(pet);

        assertNotNull(savedPet);
    }

    @Test
    void saveNoId() {
        Pet pet = new Pet();
        Pet savedPet = petServiceMap.save(pet);

        assertNotNull(pet);
        assertNotNull(pet.getId());
    }
}