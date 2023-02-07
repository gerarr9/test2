package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
       User gerarr = new User("gerarr","123");
       User oleg = new User("oleg","321");
       User sun = new User("firblain","a3ad3");
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(gerarr);
        userRepository.addUser(oleg);
        userRepository.addUser(sun);
        UserService userService = new UserService(userRepository);
        userService.createNewUser("Biba","boba");
        System.out.println(userRepository.getUserForLogin("Biba"));
        System.out.println(userService.getAllLogin());
    }
}