package guru.springframework.springpetclinic.services.springdatajpa;

import guru.springframework.springpetclinic.model.Visit;
import guru.springframework.springpetclinic.repositories.VisitRepository;
import guru.springframework.springpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visitSet = new HashSet<>();

        visitRepository.findAll().forEach(visit -> {
            visitSet.add(visit);
        });

        return visitSet;
    }

    @Override
    public Visit findById(Long id) {
        Optional<Visit> visitOptional = visitRepository.findById(id);

        if (visitOptional.isPresent()) {
            return visitOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
