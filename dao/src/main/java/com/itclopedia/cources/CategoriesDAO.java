package com.itclopedia.cources;

import com.itclopedia.cources.database.DBConnection;
import com.itclopedia.cources.models.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriesDAO {
    private static final String INSERT_CATEGORIES = "INSERT INTO CATEGORIES(NAME) VALUES(?)";
    private static final String UPDATE_CATEGORY = "UPDATE CATEGORIES SET NAME = ? WHERE ID = ?";
    private static final String DELETE_CATEGORY = "DELETE FROM CATEGORIES WHERE ID = ?";

    public void addCategory(Categories categories) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CATEGORIES)) {
            statement.setString(1, categories.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(int id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    public void updateCategory(Categories categories) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY);
        statement.setString(1, categories.getName());
        statement.setInt(2, categories.getId());
        statement.executeUpdate();
        statement.close();
    }

}
