package com.kukit.platform.registration.presentation.frontend.web;

import com.kukit.platform.registration.application.RegistrationSystem;
import com.kukit.platform.registration.infrastructure.ProductionRepository;
import com.kukit.platform.registration.infrastructure.UserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories(basePackages = "com.kukit.platform.registration.infrastructure")
@EntityScan(basePackages = {"com.kukit.platform.registration.domain.user",
        "com.kukit.platform.registration.domain.role"})
class RegistrationSystemConfiguration {

    @Bean
    ProductionRepository productionRepository(UserRepository userRepository) {
        return new ProductionRepository(userRepository);
    }

    @Bean
    public RegistrationSystem registrationSystem(ProductionRepository productionRepository) {
        return com.kukit.platform.registration.application.RegistrationSystemConfiguration
                .registrationSystem(productionRepository);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
