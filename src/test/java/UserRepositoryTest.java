import org.example.User;
import org.example.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;

public class UserRepositoryTest {
    User user = new User("user", "pass");
    UserRepository userRepository;
    @BeforeEach
    void setUo(){
        userRepository = new UserRepository();
    }
    @Test
    void User() {
        User user = new User("user", "pass");
        userRepository.addUser(user);
        Assertions.assertEquals(userRepository.getAllUsers(), userRepository.getAllUsers());
    }


    @Test
    void emptyUser() {
        Assertions.assertTrue(userRepository.getAllUsers().isEmpty());
    }

    @Test
    void checForLoginUserYes() {
        userRepository.addUser(user);
        Optional<User> us = userRepository.getUserForLogin("user");
        Assertions.assertTrue(us.isPresent());

    }
    @Test
    void checForLoginUserNo() {
        userRepository.addUser(user);
        Optional<User> us = userRepository.getUserForLogin("user1");
        Assertions.assertFalse(us.isPresent());

    }
    @Test
    void checForLoginAndPassUserYes() {
        userRepository.addUser(user);
        Optional<User> us = userRepository.getUserForLoginAndPass("user","pass");
        Assertions.assertTrue(us.isPresent());

    }
    @Test
    void checForLoginAndPassUserNo() {
        userRepository.addUser(user);
        Optional<User> us = userRepository.getUserForLoginAndPass("user","pass1");
        Assertions.assertFalse(us.isPresent());

    }
}
