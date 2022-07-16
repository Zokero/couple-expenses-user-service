package com.kukit.platform.registration.infrastructure;

import com.kukit.platform.registration.domain.ports.Repository;
import com.kukit.platform.registration.domain.user.User;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductionRepository implements Repository {

    UserRepository userRepository;

    @Override
    public void register(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserBy(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserBy(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByName(username));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
