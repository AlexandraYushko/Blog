package com.itclopedia.cources;

import com.itclopedia.cources.models.User;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserService userService;
    private UserDAO userDAO;

    @BeforeEach
    public void setup() {
        userDAO = Mockito.mock(UserDAO.class);
        userService = new UserService(userDAO);
    }

    @Test
    public void testCreate() {
        User user = new User();
        user.setName("Name");
        user.setEmail("email@example.com");
        user.setPassword("Password");
        doNothing().when(userDAO).addUser(user);
        userService.createUser(user);
        verify(userDAO, times(1)).addUser(user);
        assertEquals("Name", user.getName());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("Name");
        user.setPassword("Password");
        doNothing().when(userDAO).updateUser(user);
        userService.updateUser(user);
        verify(userDAO, times(1)).updateUser(user);
        assertEquals("Name", user.getName());
    }

    @Test
    public void testDelete() {
        int id = 3;
        doNothing().when(userDAO).deleteUser(id);
        when(userDAO.getUserById(id)).thenReturn(null);
        userService.deleteUser(id);
        verify(userService, times(1)).deleteUser(id);
        User deletedUser = userService.getUserById(id);
        assertNull(deletedUser);
    }

    @Test
    public void testRead() {
        int id = 3;
        User user = new User();
        user.setName("Name");
        when(userDAO.getUserById(id)).thenReturn(user);
        User readingUser = userService.getUserById(id);
        assertEquals("Name", readingUser.getName());
    }
}
