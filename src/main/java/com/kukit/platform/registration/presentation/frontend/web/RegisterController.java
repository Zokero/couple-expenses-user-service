package com.kukit.platform.registration.presentation.frontend.web;


import com.kukit.platform.registration.application.RegistrationSystem;
import com.kukit.platform.registration.domain.user.User;
import com.kukit.platform.registration.presentation.frontend.dto.UserRepresentation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
class RegisterController {

    RegistrationSystem registrationSystem;

    public RegisterController(RegistrationSystem registrationSystem) {
        this.registrationSystem = registrationSystem;
    }

    @GetMapping("/")
    public String viewHomePage(){
        return "homePage";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = registrationSystem.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @PostMapping("/process_register")
    public String processRegister(UserRepresentation user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        registrationSystem.add(user.asUser());

        return "register_success";
    }

}
