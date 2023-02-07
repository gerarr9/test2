package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class UserRepository {
    List<User> userList = new ArrayList<>();


    public void addUser(User user) {
        userList.add(user);
    }

    public Collection<User> getAllUsers() {
        return userList;

    }

    public Optional<User> getUserForLogin(String login)  {
    Optional<User> us =   userList.stream().filter(e->e.getLogin().equals(login)).findAny();
    if (us.isEmpty()){
        return Optional.empty();
    }
    return  us;
    }
    public Optional<User> getUserForLoginAndPass(String login, String password)  {
        Optional<User> us =   userList.stream().filter(e->e.getLogin().equals(login) && e.getPassword().equals(password)).findAny();
        if (us.isEmpty()){
            return Optional.empty();
        }
        return  us;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "userList=" + userList +
                '}';
    }
}
