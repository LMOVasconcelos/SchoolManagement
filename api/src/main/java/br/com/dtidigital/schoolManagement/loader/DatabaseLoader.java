package br.com.dtidigital.schoolManagement.loader;

import br.com.dtidigital.schoolManagement.domain.model.Discipline;
import br.com.dtidigital.schoolManagement.repository.DisciplineRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    @Autowired
    private DisciplineRepository repository;

    @PostConstruct
    private void initDatabase() {
        repository.save(Discipline.builder().name("Português").build());
        repository.save(Discipline.builder().name("Matemática").build());
        repository.save(Discipline.builder().name("Geografia").build());
        repository.save(Discipline.builder().name("História").build());
        repository.save(Discipline.builder().name("Inglês").build());
    }
}
