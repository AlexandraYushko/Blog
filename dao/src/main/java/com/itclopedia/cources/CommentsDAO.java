package com.itclopedia.cources;

import com.itclopedia.cources.models.Categories;
import com.itclopedia.cources.models.Comments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CommentsDAO {
    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void addComments(Comments comments) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(comments);
            transaction.commit();
        }
    }

    public void updateComments(Comments comments) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(comments);
            transaction.commit();
        }
    }

    public void deleteComments(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Comments comment = session.get(Comments.class, id);
            if (comment != null) {
                session.remove(comment);
                transaction.commit();
            }
        }
    }

    public Comments getCommentsById(int commentId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Comments.class, commentId);
        }
    }
}
