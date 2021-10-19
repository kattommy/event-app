package com.project.eventapp.controller;


import com.project.eventapp.model.User;
import com.project.eventapp.repository.UserRepository;
import com.project.eventapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    private UserService userService;

    @GetMapping("/list")
    public String getUsers(@ModelAttribute("user") User user){
        userService.getUsers(user);
        return "users";
    }

    @GetMapping("/addUser")
    public String getAddUser() {
        return "addUser";
    }

    @PostMapping(value = "/addUser")
    public RedirectView postAddUser(@ModelAttribute("user") User user){
        return userService.postAddUser(user);
    }
 
    @GetMapping("/editUser/{id}")
    public String getEditUser(Model model, @PathVariable("id") Long id) {
        return userService.getEditUser(model,id);
    }

    @PostMapping(value = "/editUser/{id}")
    public RedirectView postEditUser(@ModelAttribute("user") User editedUser, @PathVariable("id") Long id) {
        return userService.postEditUser(editedUser,id);
    }

    @GetMapping("/deleteUser/{id}")
    public String getDeleteUser(@ModelAttribute("user") User editedUser,@PathVariable("id") Long id) {
       return userService.getDeleteUser(editedUser, id);
    }

    @PostMapping(value="/deleteUser/{id}")
    public RedirectView postDeleteUser(@ModelAttribute("user") User editedUser,@PathVariable("id") Long id) {
       return userService.postDeleteUser(editedUser, id);
    }
}

