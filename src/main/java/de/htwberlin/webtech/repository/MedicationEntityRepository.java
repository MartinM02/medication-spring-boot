package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.MedicationEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationEntityRepository extends JpaRepository<MedicationEntry, Long> {
}
