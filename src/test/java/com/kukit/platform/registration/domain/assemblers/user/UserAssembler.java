package com.kukit.platform.registration.domain.assemblers.user;

import com.kukit.platform.registration.domain.user.User;

public final class UserAssembler implements UserIdAssembler,
        UserPasswordAssembler,
        UserNameAssembler,
        UserSurnameAssembler,
        UserEmailAssembler {

    private long id;
    private String password;
    private String name;
    private String surname;
    private String email;

    private UserAssembler() {
    }

    public static UserIdAssembler user() {
        return new UserAssembler();
    }

    @Override
    public UserPasswordAssembler withId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public UserNameAssembler withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public UserSurnameAssembler withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserEmailAssembler withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public User withEmail(String email) {
        return User.builder()
                .id(id)
                .password(password)
                .name(name)
                .surname(surname)
                .email(email)
                .build();
    }

}
