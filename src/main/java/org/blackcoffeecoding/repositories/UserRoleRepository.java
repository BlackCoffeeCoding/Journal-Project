package org.blackcoffeecoding.repositories;

import org.blackcoffeecoding.models.entities.Role;
import org.blackcoffeecoding.models.enums.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findRoleByName(UserRoles role);
}
