package com.project.eventapp.controller;


import com.project.eventapp.model.User;
import com.project.eventapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.GeneratedValue;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    @GetMapping
    public String getUsers(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/addUser")
    public String getAddUser() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public RedirectView postAddUsers(@ModelAttribute("user") User user){
        userRepository.save(user);
        return new RedirectView("/users");
    }
    @PostMapping("/deleteUser/{id}") // czy to {id} jest wymagane i jeśli tak to do czego bo trochę nie ogarniam
    public RedirectView postDeleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return new RedirectView("/users");
    }
}

