package com.itclopedia.cources;

import com.itclopedia.cources.models.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public AnswerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAnswer(Answer answer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(answer);
            transaction.commit();
        }
    }

    public void updateAnswer(Answer answer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(answer);
            transaction.commit();
        }
    }

    public void deleteAnswer(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Answer answer = session.get(Answer.class, id);
            if (answer != null) {
                session.remove(answer);
                transaction.commit();
            }
        }
    }

    public Answer getAnswerById(int categoryId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Answer.class, categoryId);
        }
    }

    public List<Answer> getAllAnswer() {
        Transaction transaction = null;
        List<Answer> answer = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            answer = session.createQuery("from Answers", Answer.class).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return answer;
    }
}
