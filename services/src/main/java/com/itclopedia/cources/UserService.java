package com.itclopedia.cources;

import com.itclopedia.cources.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(User user) {
        try {
            if (userDAO.isUserExists(user.getEmail(), user.getName())) {
                System.out.println("Такой пользователь уже существует!");
            }
            userDAO.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User readUser(int id) {
        return userDAO.getUserById(id);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(int idUser) {
        userDAO.deleteUser(idUser);
    }

    public boolean isUserExists(String email, String username) {
        try {
            return userDAO.isUserExists(email, username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }
}
