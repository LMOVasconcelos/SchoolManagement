package br.com.dtidigital.schoolManagement.repository;

import br.com.dtidigital.schoolManagement.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query("SELECT s FROM Student s WHERE s.id = :id")
    Optional<Student> findStudentById(@Param("id") int id);
}
