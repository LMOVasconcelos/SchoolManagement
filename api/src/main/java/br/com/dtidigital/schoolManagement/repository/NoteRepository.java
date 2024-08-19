package br.com.dtidigital.schoolManagement.repository;

import br.com.dtidigital.schoolManagement.domain.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Integer> {
}
