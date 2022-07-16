package com.kukit.platform.registration.presentation.frontend.dto;

import com.kukit.platform.registration.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UserRepresentation {

    private String password;
    private String name;
    private String surname;
    private String email;

    public User asUser() {
        return User.builder()
                .password(password)
                .name(name)
                .surname(surname)
                .email(email)
                .build();
    }
}

