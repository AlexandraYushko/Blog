package com.itclopedia.cources;

import com.itclopedia.cources.database.DBConnection;
import com.itclopedia.cources.models.Comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentsDAO {
    private static final String INSERT_COMMENT = "INSERT INTO COMMENTS (ARTICLE_ID, AUTHOR_ID, TEXT) VALUES (?, ?, ?)";
    private static final String UPDATE_COMMENT = "UPDATE COMMENTS SET TEXT = ?";
    private static final String DELETE_COMMENT = "DELETE FROM ARTICLES WHERE ID = ?";
    private static final String SELECT_COMMENT = "SELECT * FROM comments WHERE article_id = ?";

    public void addComments(Comments comments) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_COMMENT)) {
            statement.setInt(1, comments.getArticle_id());
            statement.setInt(2, comments.getAuthor_id());
            statement.setString(3, comments.getText());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateComments(Comments comments) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_COMMENT)) {
            statement.setString(1, comments.getText());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteComments(int id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_COMMENT)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Comments> getAllComments(int articleId) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_COMMENT);
        statement.setInt(1, articleId);
        ResultSet resultSet = statement.executeQuery();

        List<Comments> comments = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int authorId = resultSet.getInt("author_id");
            String text = resultSet.getString("text");
            Comments comment = new Comments(id, authorId, articleId, text);
            comments.add(comment);
        }
        resultSet.close();
        statement.close();
        return comments;
    }
}
