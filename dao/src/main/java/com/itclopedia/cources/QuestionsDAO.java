package com.itclopedia.cources;

import com.itclopedia.cources.database.DBConnection;
import com.itclopedia.cources.models.Questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestionsDAO {
    private static final String INSERT_QUESTION = "INSERT INTO QUESTIONS (QUESTION, SERVEY_ID) VALUES (?, ?)";
    private static final String UPDATE_QUESTION = "UPDATE QUESTIONS SET QUESTION = ?";
    private static final String DELETE_QUESTION = "DELETE FROM QUESTIONS WHERE ID = ?";

    public void addQuestion(Questions questions) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUESTION)) {
            statement.setString(1, questions.getQuestion());
            statement.setInt(2, questions.getServeyId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateQuestion(Questions questions) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUESTION)) {
            statement.setString(1, questions.getQuestion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteQuestion(int id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUESTION)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
