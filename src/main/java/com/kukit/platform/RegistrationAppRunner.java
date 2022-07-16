package com.kukit.platform;

import com.kukit.platform.registration.domain.role.Role;
import com.kukit.platform.registration.domain.user.User;
import com.kukit.platform.registration.infrastructure.ProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistrationAppRunner implements CommandLineRunner {

    @Autowired
    ProductionRepository productionRepository;

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedAdminPassword = bCryptPasswordEncoder.encode("admin");
        User adminUser = User.builder().id(1L).email("admin@admin.com").name("admin").password(encryptedAdminPassword).surname("admin").build();
        Role userRole = new Role(1L, "ADMIN", List.of(adminUser));
        adminUser.setRoles(List.of(userRole));
        productionRepository.register(adminUser);
    }
}
