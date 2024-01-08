package com.test.user;

import com.user.User;
import com.user.UserException;
import com.user.UserRepositoryImpl;
import com.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepositoryImpl userRepository;

    String id;
    String firstName;
    String lastName;
    String email;
    String mobileNumber;

    @BeforeEach
    void init(){
        id = "111";
        firstName = "Srinath";
        lastName = "Rayabarapu";
        email = "srinath.rbp@gmail.com";
        mobileNumber = "0000000000";
    }

    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObject() {

        // Arrange
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(true);

        // Act
        User user = userService.save(new User(id, firstName, lastName, email, mobileNumber));

        // Assert
        assertNotNull(user, "User object should not be null!");
        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));
    }

    @Test
    void testCreateUser_whenUserFistNameIsEmpty_returnUserException() {

        // Arrange
//        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(false);

        // Act
        UserException userException = assertThrows(UserException.class, () -> {
            userService.save(new User(id, "", lastName, email, mobileNumber));
        });

        // Assert
        assertEquals("User First name is either null or blank/empty!", userException.getMessage());
    }

}
