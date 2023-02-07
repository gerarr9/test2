package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
 private   final UserRepository userRepository ;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<String> getAllLogin() {
        return userRepository.userList.stream().map(User::getLogin).collect(Collectors.toList());
    }

    public void createNewUser(String login, String pass) {
        User user = new User(login, pass);
        if (user.getLogin() == null || user.getPassword() == null || user.getLogin().isEmpty() || user.getLogin().isBlank() || user.getPassword().isEmpty() || user.getPassword().isBlank()) {
            throw new IllegalArgumentException();
        }
        boolean us = this.userRepository
                .getAllUsers()
                .stream()
                .anyMatch(u -> u.equals(user));
        if (us) {
            throw new UserNonUniqueException();
        }
        userRepository.addUser(user);

    }

}
