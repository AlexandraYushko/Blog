package com.itclopedia.cources;

import com.itclopedia.cources.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    public void testCreate() {
        User user = new User();
        user.setName("Name");
        user.setEmail("email@example.com");
        user.setPassword("Password");
        userService.createUser(user);
        verify(userRepository, times(1)).save(user);
        assertEquals("Name", user.getName());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("Name");
        user.setPassword("Password");
        when(userRepository.existsById(user.getUuid())).thenReturn(null);
        userService.updateUser(user);
        verify(userRepository, times(1)).save(user);
        assertEquals("Name", user.getName());
    }

    @Test
    public void testDelete() {
        int id = 3;
        when(userRepository.existsById(id)).thenReturn(null);
        userService.deleteUser(id);
        verify(userRepository, times(1)).deleteById(id);

    }

    @Test
    public void testRead() {
        int id = 3;
        User user = new User();
        user.setName("Name");
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        User readingUser = userService.getUserById(id);
        assertEquals("Name", readingUser.getName());
    }
}
