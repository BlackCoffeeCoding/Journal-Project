package org.blackcoffeecoding.repositories;

import org.blackcoffeecoding.models.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,String> {
    Optional<Attendance> findById(String id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Attendance WHERE id=:id")
    void deleteById(String id);
}
