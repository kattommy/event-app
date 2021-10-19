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
        return userService.postAddUser(user);
    }
 
    @GetMapping("/editUser/{id}")
    public String getEditUser(Model model, @PathVariable("id") Long id) {
        return userService.getEditUser(model,id);
    }

    @PostMapping("/editUser/{id}")
    public RedirectView postEditUser(@ModelAttribute("user") User editedUser, @PathVariable("id") Long id) {
        editedUser.setId(id);
        userRepository.save(editedUser);
        return new RedirectView("/users");
    }

    @GetMapping("/deleteUser/{id}")
    public String getDeleteUser(Model model,@PathVariable("id") Long id) {
        User userDelete = userRepository.getById(id);
        model.addAttribute("user",userDelete);
        return "deleteUser";
    }

    @PostMapping("/deleteUser/{id}")
    public RedirectView postDeleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return new RedirectView("/users");
    }
}

