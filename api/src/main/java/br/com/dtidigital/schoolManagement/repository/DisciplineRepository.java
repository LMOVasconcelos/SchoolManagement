package br.com.dtidigital.schoolManagement.repository;

import br.com.dtidigital.schoolManagement.domain.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DisciplineRepository extends JpaRepository<Discipline,Integer> {
    @Query("SELECT d FROM Discipline d WHERE d.id = :id")
    Optional<Discipline> findDisciplineById(@Param("id") int id);
}
