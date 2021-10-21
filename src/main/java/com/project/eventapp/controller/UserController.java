package com.project.eventapp.controller;


import com.project.eventapp.model.User;
import com.project.eventapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "display/users/allUsers";
    }

    @GetMapping("/addUser")
    public String getAddUser() {
        return "access/register";
    }

    @PostMapping("/addUser")
    public RedirectView postAddUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return new RedirectView("/users");
    }

    @GetMapping("/editUser/{id}")
    public String getEditUser(Model model, @PathVariable("id") Long id) {
        User userToEdit = userService.findUserById(id);
        model.addAttribute("user", userToEdit);
        return "manage/account/editUser";
    }

    @PostMapping("/editUser/{id}")
    public RedirectView postEditUser(@ModelAttribute("user") User editedUser, @PathVariable("id") Long id) {
        editedUser.setId(id);
        userService.saveUser(editedUser);
        return new RedirectView("/users");
    }

    @GetMapping("/deleteUser/{id}")
    public String getDeleteUser(Model model, @PathVariable("id") Long id) {
        User userDelete = userService.findUserById(id);
        model.addAttribute("user", userDelete);
        return "manage/account/deleteUser";
    }

    @PostMapping("/deleteUser/{id}")
    public RedirectView postDeleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new RedirectView("/users");
    }
}

