package com.itclopedia.cources;

import com.itclopedia.cources.database.DBConnection;
import com.itclopedia.cources.models.Tags;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TagsDAO {
    private static final String INSERT_TAG = "INSERT INTO TAGS (NAME, PUBLICATIONTIME) VALUES (?, CURRENT_TIMESTAMP";
    private static final String UPDATE_TAG = "UPDATE TAGS SET NAME = ?";
    private static final String DELETE_TAG = "DELETE FROM TAGS WHERE ID = ?";

    public void addTags(Tags tags) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_TAG)) {
            statement.setString(1, tags.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTags(Tags tags) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TAG)) {
            statement.setString(1, tags.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTags(int id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TAG)) {
            statement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
