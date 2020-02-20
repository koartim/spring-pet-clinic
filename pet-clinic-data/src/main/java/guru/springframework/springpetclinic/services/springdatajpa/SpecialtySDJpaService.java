package guru.springframework.springpetclinic.services.springdatajpa;

import guru.springframework.springpetclinic.model.Specialty;
import guru.springframework.springpetclinic.repositories.SpecialtyRepository;
import guru.springframework.springpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SpecialtySDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {

        Set<Specialty> specialtySet =  new HashSet<>();

        specialtyRepository.findAll().forEach(specialty -> {
            specialtySet.add(specialty);
        });
        return specialtySet;
    }

    @Override
    public Specialty findById(Long id) {

        Optional<Specialty> specialtyOptional = specialtyRepository.findById(id);

        if (specialtyOptional.isPresent()) {
            return specialtyOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Specialty save(Specialty specialty) {

        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
