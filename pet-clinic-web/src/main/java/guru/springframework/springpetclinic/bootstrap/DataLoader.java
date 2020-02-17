package guru.springframework.springpetclinic.bootstrap;

import guru.springframework.springpetclinic.model.*;
import guru.springframework.springpetclinic.services.OwnerService;
import guru.springframework.springpetclinic.services.SpecialtyService;
import guru.springframework.springpetclinic.services.VetService;
import guru.springframework.springpetclinic.services.map.PetTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Winnie");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Luna");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Tim");
        owner1.setLastName("Koar");
        owner1.setAddress("502 Windermere Ave");
        owner1.setCity("Interlaken");
        owner1.setTelephone("9084339474");

        Pet timsPet = new Pet();
        timsPet.setPetType(savedDogPetType);
        timsPet.setOwner(owner1);
        timsPet.setBirthdate(LocalDate.now());
        timsPet.setName("Winnie");
        owner1.getPets().add(timsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Terrance");
        owner2.setLastName("Koar");
        owner2.setAddress("123 Hipster Ave");
        owner2.setCity("Brooklyn");
        owner2.setTelephone("9084338484");

        Pet terrancesPet = new Pet();
        terrancesPet.setPetType(savedCatPetType);
        terrancesPet.setOwner(owner2);
        terrancesPet.setBirthdate(LocalDate.now());
        terrancesPet.setName("Oliver");
        owner2.getPets().add(terrancesPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Max");
        vet2.setLastName("Sam");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
