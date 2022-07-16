package com.kukit.platform.registration.infrastructure;

import com.kukit.platform.registration.domain.ports.Repository;
import com.kukit.platform.registration.domain.user.User;
import java.util.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryRepository implements Repository {

    private final Map<Long, User> users = new HashMap<>();

    @Override
    public void register(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public Optional<User> getUserBy(long id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> getUserBy(String email) {

        return users.values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }
}
