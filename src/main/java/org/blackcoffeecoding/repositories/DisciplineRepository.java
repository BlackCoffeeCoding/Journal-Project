package org.blackcoffeecoding.repositories;

import org.blackcoffeecoding.models.entities.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline,String> {
    Optional<Discipline> findByCode(Integer code);

    @Modifying
    @Transactional
    @Query("DELETE FROM Discipline WHERE code=:code")
    void deleteByCode(Integer code);
}
