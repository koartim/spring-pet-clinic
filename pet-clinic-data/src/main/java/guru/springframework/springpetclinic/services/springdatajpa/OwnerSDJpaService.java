package guru.springframework.springpetclinic.services.springdatajpa;

import guru.springframework.springpetclinic.model.Owner;
import guru.springframework.springpetclinic.repositories.OwnerRepository;
import guru.springframework.springpetclinic.repositories.PetRepository;
import guru.springframework.springpetclinic.repositories.PetTypeRepository;
import guru.springframework.springpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetTypeRepository petTypeRepository;
    private final PetRepository petRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {

        Set<Owner> owners =  new HashSet<>();

        ownerRepository.findAll().forEach(owner -> {
            owners.add(owner);
        });

        return owners;
    }

    @Override
    public Owner findById(Long id) {

        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (optionalOwner.isPresent()) {
            return optionalOwner.get();
        } else {
            return null;
        }
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
