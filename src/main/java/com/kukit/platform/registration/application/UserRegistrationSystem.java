package com.kukit.platform.registration.application;

import com.kukit.platform.registration.domain.exceptions.UserAlreadyExists;
import com.kukit.platform.registration.domain.ports.Repository;
import com.kukit.platform.registration.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
class UserRegistrationSystem implements RegistrationSystem {

    private final Repository repository;

    public static RegistrationSystem newInstance(Repository repository) {
        return new UserRegistrationSystem(repository);
    }

    @Override
    public void add(User user) {
        Optional<User> foundUser = findByEmail(user.getEmail());
        if (foundUser.isEmpty()) {
            repository.register(user);
        } else {
            throw new UserAlreadyExists("User with email: " + user.getEmail() + " already exists!");
        }
    }

    @Override
    public Optional<User> getUserBy(long id) {
        return repository.getUserBy(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.getUserBy(email);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

}
