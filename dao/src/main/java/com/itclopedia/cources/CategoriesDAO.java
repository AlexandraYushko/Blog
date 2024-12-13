package com.itclopedia.cources;

import com.itclopedia.cources.models.Articles;
import com.itclopedia.cources.models.Categories;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class CategoriesDAO {

    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void addCategory(Categories categories) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(categories);
            transaction.commit();
        }
    }

    public void deleteCategory(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Categories categories = session.get(Categories.class, id);
            if (categories != null) {
                session.remove(categories);
                transaction.commit();
            }
        }
    }

    public void updateCategory(Categories categories) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(categories);
            transaction.commit();
        }
    }

    public Categories getCategoriesById(int categoriesId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Categories.class, categoriesId);
        }
    }
}
