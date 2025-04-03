package org.blackcoffeecoding.repositories;

import org.blackcoffeecoding.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    Optional<Student> findByGbNumber(Integer gbNumber);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student WHERE gbNumber=:gbNumber")
    void deleteByGbNumber(Integer gbNumber);
}
