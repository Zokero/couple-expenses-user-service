package com.kukit.platform.registration.application;

import com.kukit.platform.registration.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface RegistrationSystem {

    void add(User user);

    Optional<User> getUserBy(long l);

    Optional<User> findByEmail(String email);

    List<User> findAll();
}
