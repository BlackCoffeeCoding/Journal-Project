package org.blackcoffeecoding.models.entities;

import jakarta.persistence.*;
import org.blackcoffeecoding.models.enums.UserRoles;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private UserRoles name;

    public Role(UserRoles name) {
        this.name = name;
    }

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    public UserRoles getName() {
        return name;
    }
    public void setName(UserRoles name) {
        this.name = name;
    }
}