package com.itclopedia.cources;

import com.itclopedia.cources.models.Questions;
import com.itclopedia.cources.models.Surveys;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SurveysDAO {
    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void addSurveys(Surveys serveys) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(serveys);
            transaction.commit();
        }
    }

    public void updateSurveys(Surveys serveys) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(serveys);
            transaction.commit();
        }
    }

    public void deleteSurveys(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Questions question = session.get(Questions.class, id);
            if (question != null) {
                session.remove(question);
                transaction.commit();
            }
        }
    }

    public Surveys getSurveysById(int surveysId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Surveys.class, surveysId);
        }
    }
}
