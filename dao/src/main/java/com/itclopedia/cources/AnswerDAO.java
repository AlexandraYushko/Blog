package com.itclopedia.cources;

import com.itclopedia.cources.database.DBConnection;
import com.itclopedia.cources.models.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAO {
    private static final String INSERT_ANSWER = "INSERT INTO ANSWER (ANSWER, IS_CORRECT, QUESTION_ID) VALUES (?, ?, ?)";
    private static final String UPDATE_ANSWER = "UPDATE ANSWER SET ANSWER = ?, IS_CORRECT = ?";
    private static final String DELETE_ANSWER = "DELETE FROM ANSWER WHERE ID = ?";
    private static final String SELECT_ANSWER = "SELECT * FROM ANSWER WHERE QUESTION_ID = ?";


    public void addAnswer(Answer answer) {
        try(Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_ANSWER)) {
            statement.setString(1, answer.getAnswer());
            statement.setBoolean(2, answer.isCorrect());
            statement.setInt(3, answer.getQuestionId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAnswer(Answer answer) {
        try(Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_ANSWER)) {
            statement.setString(1, answer.getAnswer());
            statement.setBoolean(2, answer.isCorrect());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAnswer(int id) {
        try(Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_ANSWER)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Answer> getAllAnswer(int questionId) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ANSWER)) {

            statement.setInt(1, questionId);
            ResultSet resultSet = statement.executeQuery();

            List<Answer> answers = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String answer = resultSet.getString("answer");
                Boolean isCorrect = resultSet.getBoolean("is_correct");
                Answer answer1 = new Answer(id, questionId, answer, isCorrect);
                answers.add(answer1);
            }
            return answers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
