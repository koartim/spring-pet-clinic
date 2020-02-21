package guru.springframework.springpetclinic.services.springdatajpa;

import guru.springframework.springpetclinic.model.PetType;
import guru.springframework.springpetclinic.repositories.PetTypeRepository;
import guru.springframework.springpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petType -> {
            petTypes.add(petType);
        });
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        Optional<PetType> petTypeOptional = petTypeRepository.findById(id);
        if (petTypeOptional.isPresent()) {
            return petTypeOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
