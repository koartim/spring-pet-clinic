package guru.springframework.springpetclinic.bootstrap;

import guru.springframework.springpetclinic.model.Owner;
import guru.springframework.springpetclinic.model.PetType;
import guru.springframework.springpetclinic.model.Vet;
import guru.springframework.springpetclinic.services.OwnerService;
import guru.springframework.springpetclinic.services.VetService;
import guru.springframework.springpetclinic.services.map.OwnerServiceMap;
import guru.springframework.springpetclinic.services.map.PetTypeService;
import guru.springframework.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Winnie");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Luna");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Tim");
        owner1.setLastName("Koar");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Terrance");
        owner2.setLastName("Koar");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Max");
        vet2.setLastName("Sam");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
