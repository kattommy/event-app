package com.project.eventapp.controller;


import com.project.eventapp.model.User;
import com.project.eventapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping
    public String getUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/users";
    }

    @GetMapping("/addUser")
    public String getAddUser(@ModelAttribute User user) {
        return "user/addUser";
    }

    @PostMapping("/addUser")
    public String postAddUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
       if(bindingResult.hasErrors()){
           return "user/addUser";
       }
        userService.createUser(user);
        return "user/users";
    }

    @GetMapping("/editUser/{id}")
    public String getEditUser(Model model, @PathVariable("id") Long id) {
        User userToEdit = userService.findUserById(id);
        model.addAttribute("user", userToEdit);
        return "user/editUser";
    }

    @PostMapping("/editUser/{id}")
    public RedirectView postEditUser(@ModelAttribute("user") User editedUser, @PathVariable("id") Long id) {
        editedUser.setId(id);
        userService.updateUser(editedUser);
        return new RedirectView("/users");
    }

    @GetMapping("/deleteUser/{id}")
    public String getDeleteUser(Model model, @PathVariable("id") Long id) {
        User userDelete = userService.findUserById(id);
        model.addAttribute("user", userDelete);
        return "user/deleteUser";
    }

    @PostMapping("/deleteUser/{id}")
    public RedirectView postDeleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new RedirectView("/users");
    }
}

