package com.kukit.platform.registration.presentation.frontend.dto;

import com.kukit.platform.registration.domain.ports.Repository;
import com.kukit.platform.registration.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private Repository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.getUserBy(username);
        if (user.isEmpty()) {
            user = userRepo.getUserByUsername(username);
            if (user.isEmpty()) {
                throw new UsernameNotFoundException("User not found");
            }
        }
        return new CustomUserDetails(user.get());
    }

}