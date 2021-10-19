package com.project.eventapp.service;

import com.project.eventapp.model.User;
import com.project.eventapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void saveUser(User userToSave){
        userRepository.save(userToSave);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
