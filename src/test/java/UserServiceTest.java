import org.example.User;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private  UserRepository userRepository;
    @InjectMocks
    UserService userService  ;


    @Test
    void whenNetworkExceptionIsRaisedThenServiceReturnsZero() {
        when(userRepository.getAllUsers()).thenThrow(new RuntimeException());
        assertThat(userService.getAllLogin()).isEqualTo(0);
    }
    @Test
    void whenRepositoryReturnsNullThenSomethingHappened() {
        when(userRepository.getAllUsers()).thenReturn(null);
        assertThat(userService.getAllLogin()).isEqualTo(0);
    }
}
