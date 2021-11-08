package com.project.eventapp.service;

import com.project.eventapp.model.User;
import com.project.eventapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
//  Dodaj w serwisie metodę get all users by event
//  (by mieć podgląd, jakie osoby zapisały się na dane wydarzenie).
//  (po skończeniu zapisów na event)
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void updateUser(User userToSave) {
        userRepository.save(userToSave);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void createUser(User user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("Użytkownik o podanym ID już istnieje !!!");
        }
        updateUser(user);
    }


//    @Override
//    public User loadUserByUsername(String email) throws UsernameNotFoundException {
//        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Brak użytkownika o email: " + email));
//    }
}
