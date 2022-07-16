package com.kukit.platform.registration.domain.ports;

import com.kukit.platform.registration.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface Repository {

    void register(User user);

    Optional<User> getUserBy(long id);

    Optional<User> getUserBy(String email);

    Optional<User> getUserByUsername(String username);

    List<User> findAll();
}
