package org.blackcoffeecoding.repositories;

import org.blackcoffeecoding.models.entities.Attendance;
import org.blackcoffeecoding.models.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,String> {
    Optional<Lesson> findById(String id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Lesson WHERE id=:id")
    void deleteById(String id);
}
