package com.itclopedia.cources;

import com.itclopedia.cources.models.User;

import java.sql.SQLException;

public class UserService {
    private UserDAO userDAO;

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
        return userDAO.getUser(id);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(int idUser) {
        userDAO.deleteUser(idUser);
    }
}
