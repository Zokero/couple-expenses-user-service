package com.kukit.platform.registration.application;

import com.kukit.platform.registration.domain.ports.Repository;
import com.kukit.platform.registration.infrastructure.InMemoryRepository;

public final class RegistrationSystemConfiguration {

    public static RegistrationSystem registrationSystem(Repository repository) {
        return UserRegistrationSystem.newInstance(repository);
    }

    public static RegistrationSystem registrationSystem() {
        return registrationSystem(new InMemoryRepository());
    }

}
