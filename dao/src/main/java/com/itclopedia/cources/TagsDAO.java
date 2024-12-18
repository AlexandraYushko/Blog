package com.itclopedia.cources;

import com.itclopedia.cources.models.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TagsDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public TagsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addTags(Tag tags) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(tags);
            transaction.commit();
        }
    }

    public void updateTags(Tag tags) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(tags);
            transaction.commit();
        }
    }

    public void deleteTags(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Tag tag = session.get(Tag.class, id);
            if (tag != null) {
                session.remove(tag);
                transaction.commit();
            }
        }
    }

    public Tag getTagById(int tagId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Tag.class, tagId);
        }
    }
}
