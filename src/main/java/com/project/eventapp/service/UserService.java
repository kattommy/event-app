package com.project.eventapp.service;

import com.project.eventapp.model.User;
import com.project.eventapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(@ModelAttribute("user") User user){
        return userRepository.findAll();
    }

    public RedirectView postAddUser(@ModelAttribute("user") User user){
        userRepository.save(user);
        return new RedirectView("/users/list");
    }

    public String getEditUser(Model model, @PathVariable("id") Long id) {
        User userToEdit = userRepository.findById(id).orElse(null);
        model.addAttribute("user", userToEdit);
        return "editUser";
    }

    public RedirectView postEditUser(@ModelAttribute("user") User editedUser, @PathVariable("id") Long id) {
        editedUser.setId(id);
        userRepository.save(editedUser);
        return new RedirectView("/users/list");
    }

    public String getDeleteUser(@ModelAttribute("user") User editedUser,@PathVariable("id") Long id) {
        User userToEdit = userRepository.findById(id).orElse(null);
        return "deleteUser";
    }
    public RedirectView postDeleteUser(@ModelAttribute("user") User editedUser,@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return new RedirectView("/users/list");
    }



}
