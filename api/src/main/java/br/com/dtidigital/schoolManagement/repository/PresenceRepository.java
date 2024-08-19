package br.com.dtidigital.schoolManagement.repository;

import br.com.dtidigital.schoolManagement.domain.model.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresenceRepository extends JpaRepository<Presence,Integer> {
}
