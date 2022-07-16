package com.kukit.platform.registration.application;

import com.kukit.platform.registration.domain.exceptions.UserAlreadyExists;
import com.kukit.platform.registration.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.kukit.platform.registration.application.RegistrationSystemConfiguration.registrationSystem;
import static com.kukit.platform.registration.domain.assemblers.user.UserAssembler.user;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RegistrationSystemAddUserScenarios {

    private RegistrationSystem registrationSystem;

    @BeforeEach
    void beforeEach() {
        registrationSystem = registrationSystem();
    }

    @Test
    void Add_not_existing_user() {
        //When
        registrationSystem.add(user()
                .withId(1L)
                .withPassword("password")
                .withName("TestName")
                .withSurname("TestSurname")
                .withEmail("email@test.com"));
        Optional<User> savedUser = registrationSystem.getUserBy(1L);

        //Then
        then(savedUser.isPresent()).isTrue();
    }

    @Test
    void Report_error_on_adding_existing_user() {
        //Given
        registrationSystem.add(user()
                .withId(1L)
                .withPassword("password")
                .withName("TestName")
                .withSurname("TestSurname")
                .withEmail("email@test.com"));

        //When
        var throwable = catchThrowable(() -> registrationSystem.add(user()
                .withId(1L)
                .withPassword("password")
                .withName("TestName2")
                .withSurname("TestSurname")
                .withEmail("email@test.com")));

        //Then
        then(throwable).isInstanceOf(UserAlreadyExists.class).hasMessage("User with email: email@test.com already exists!");
    }

}