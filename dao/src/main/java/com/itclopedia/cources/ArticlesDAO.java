package com.itclopedia.cources;

import com.itclopedia.cources.database.DBConnection;
import com.itclopedia.cources.models.Articles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticlesDAO {
    private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES (AUTHOR_ID, CATEGORY_ID, " +
            "CONTENT, PREMIUM, TITLE, PUBLICATIONTIME) VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
    private static final String UPDATE_ARTICLE = "UPDATE ARTICLES SET TITLE = ?, CONTENT = ?, " +
            "CATEGORY_ID = ?";
    private static final String DELETE_ARTICLE = "DELETE FROM ARTICLES WHERE ID = ?";
    private static final String SELECT_ARTICLE = "SELECT  *  FROM ARTICLES";

    public void addArticle(Articles articles) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ARTICLE)) {
            statement.setInt(1, articles.getAuthor_id());
            statement.setInt(2, articles.getCategory_id());
            statement.setString(3, articles.getContent());
            statement.setBoolean(4, articles.isPremium());
            statement.setString(5, articles.getTitle());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateArticle(Articles articles) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ARTICLE)) {
            statement.setInt(1, articles.getCategory_id());
            statement.setString(2, articles.getTitle());
            statement.setString(3, articles.getContent());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteArticle(int id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ARTICLE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Articles> getAllArticles() {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ARTICLE)) {
            ResultSet resultSet = statement.executeQuery();
            List<Articles> articles = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                int authorId = resultSet.getInt("author_id");
                int categoryId = resultSet.getInt("category_id");
                boolean premium = resultSet.getBoolean("premium");
                Timestamp publicationTime = resultSet.getTimestamp("publicationTime");
                Articles article = new Articles(id, title, content, authorId, categoryId, premium, publicationTime);
                articles.add(article);
            }
            resultSet.close();
            statement.close();
            return articles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Articles> findArticlesByTag(String tagName) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT DISTINCT a.* FROM articles a " +
                "JOIN post_tag pt ON a.id = pt.article_id " +
                "JOIN tags t ON pt.tag_id = t.id " +
                "WHERE t.name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, tagName);
        ResultSet resultSet = statement.executeQuery();

        List<Articles> articles = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            int authorId = resultSet.getInt("author_id");
            int categoryId = resultSet.getInt("category_id");
            boolean premium = resultSet.getBoolean("premium");
            Timestamp publicationTime = resultSet.getTimestamp("publicationTime");
            Articles articles1 = new Articles(id, title, content, authorId, categoryId, premium, publicationTime);
            articles.add(articles1);
        }
        return articles;
    }
}
