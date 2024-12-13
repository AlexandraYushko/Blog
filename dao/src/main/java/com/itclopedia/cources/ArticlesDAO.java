package com.itclopedia.cources;

import com.itclopedia.cources.models.Articles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ArticlesDAO {
    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void addArticle(Articles articles) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(articles);
            transaction.commit();
        }
    }

    public void updateArticle(Articles articles) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(articles);
            transaction.commit();
        }
    }

    public void deleteArticle(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Articles article = session.get(Articles.class, id);
            if (article != null) {
                session.remove(article);
                transaction.commit();
            }
        }
    }

    public Articles getArticleById(int articleId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Articles.class, articleId);
        }
    }

    public List<Articles> getAllArticles() {
        Transaction transaction = null;
        List<Articles> articles = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            articles = session.createQuery("from Articles", Articles.class).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return articles;
    }
}
