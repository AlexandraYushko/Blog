package com.itclopedia.cources;

import com.itclopedia.cources.database.DBConnection;
import com.itclopedia.cources.models.Serveys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServeysDAO {
    private static final String INSERT_SERVEYS = "INSERT INTO SERVEYS (DESCRIPTION, QUESTION, TYPE) VALUES (?, ?, ?)";
    private static final String UPDATE_SERVEYS = "UPDATE SERVEYS SET DESCRIPTION = ?, QUESTION = ?, TYPE = ?";
    private static final String DELETE_SERVEYS = "DELETE FROM SERVEYS WHERE ID = ?";

    public void addServeys(Serveys serveys) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SERVEYS)) {
            statement.setString(1, serveys.getDescription());
            statement.setString(2, serveys.getQuestion());
            statement.setString(3, serveys.getType());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateServeys(Serveys serveys) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SERVEYS)) {
            statement.setString(1, serveys.getDescription());
            statement.setString(2, serveys.getQuestion());
            statement.setString(3, serveys.getType());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteServeys(int id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SERVEYS)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
