package guru.springframework.springpetclinic.services.springdatajpa;

import guru.springframework.springpetclinic.model.Vet;
import guru.springframework.springpetclinic.repositories.VetRepository;
import guru.springframework.springpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {

        Set<Vet> vets =  new HashSet<>();
        vetRepository.findAll().forEach(vet -> {
            vets.add(vet);
        });

        return vets;
    }

    @Override
    public Vet findById(Long id) {

        Optional<Vet> optionalVet = vetRepository.findById(id);
        if (optionalVet.isPresent()) {
            return optionalVet.get();
        } else {
            return null;
        }
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
