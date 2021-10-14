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
    public RedirectView postAddUser(@ModelAttribute("user") User user){
        userRepository.save(user);
        return new RedirectView("/users");
    }
 
    @GetMapping("/editUser/{id}")
    public String getEditUser(Model model, @PathVariable("id") Long id) {
        User userToEdit = userRepository.findById(id).orElse(null);
        model.addAttribute("user", userToEdit);
        return "editUser";
    }

    @PostMapping("/editUser/{id}")
    public RedirectView postEditUser(@ModelAttribute User editedUser, @PathVariable("id") Long id) {
        editedUser.setId(id);
        userRepository.save(editedUser);
        return new RedirectView("/users");
    }
  
   @PostMapping("/deleteUser/{id}")
    public RedirectView postDeleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return new RedirectView("users");
    }

}

