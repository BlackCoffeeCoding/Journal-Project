package org.blackcoffeecoding;

import org.blackcoffeecoding.models.entities.Role;
import org.blackcoffeecoding.models.entities.User;
import org.blackcoffeecoding.models.enums.UserRoles;
import org.blackcoffeecoding.repositories.UserRepository;
import org.blackcoffeecoding.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init implements CommandLineRunner {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final String defaultPassword;

    public Init(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, @Value("${app.default.password}") String defaultPassword) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.defaultPassword = defaultPassword;
    }

    @Override
    public void run(String... args) throws Exception {
        initRoles();
        initUsers();
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            var moderatorRole = new Role(UserRoles.MODERATOR);
            var adminRole = new Role(UserRoles.ADMIN);
            var normalUserRole = new Role(UserRoles.USER);
            userRoleRepository.save(moderatorRole);
            userRoleRepository.save(adminRole);
            userRoleRepository.save(normalUserRole);
        }
    }

    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initModerator();
            initNormalUser();
        }
    }

    private void initAdmin(){
       var adminRole = userRoleRepository.
                findRoleByName(UserRoles.ADMIN).orElseThrow();

       var adminUser = new User("admin", passwordEncoder.encode(defaultPassword), "admin@example.com", "Kirill Solntsev", 27);
       adminUser.setRoles(List.of(adminRole));

       userRepository.save(adminUser);
    }

    private void initModerator(){

        var moderatorRole = userRoleRepository.
                findRoleByName(UserRoles.MODERATOR).orElseThrow();

        var moderatorUser = new User("moderator", passwordEncoder.encode(defaultPassword), "moderator@example.com", "Georgy Zhigulin", 21);
        moderatorUser.setRoles(List.of(moderatorRole));

        userRepository.save(moderatorUser);
    }

    private void initNormalUser(){
        var userRole = userRoleRepository.
                findRoleByName(UserRoles.USER).orElseThrow();

        var normalUser = new User("user", passwordEncoder.encode(defaultPassword), "user@example.com", "Razdolbay Aleksey", 21);
        normalUser.setRoles(List.of(userRole));

        userRepository.save(normalUser);
    }
}
