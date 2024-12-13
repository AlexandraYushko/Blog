package com.itclopedia.cources;

import com.itclopedia.cources.models.Answer;
import com.itclopedia.cources.models.Questions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class QuestionsDAO {
    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void addQuestion(Questions questions) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(questions);
            transaction.commit();
        }
    }

    public void updateQuestion(Questions questions) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(questions);
            transaction.commit();
        }
    }

    public void deleteQuestion(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Questions question = session.get(Questions.class, id);
            if (question != null) {
                session.remove(question);
                transaction.commit();
            }
        }
    }

    public Questions getQuestionById(int questionId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Questions.class, questionId);
        }
    }
}
