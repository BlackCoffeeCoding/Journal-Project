package org.blackcoffeecoding.repositories;

import org.blackcoffeecoding.models.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,String> {
    Optional<Professor> findByPersonnelNumber(Integer personnelNumber);

    @Modifying
    @Transactional
    @Query("DELETE FROM Professor WHERE personnelNumber=:personnelNumber")
    void deleteByPersonnelNumber(Integer personnelNumber);
}
