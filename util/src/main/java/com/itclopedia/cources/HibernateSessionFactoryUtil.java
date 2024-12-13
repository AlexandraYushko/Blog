package com.itclopedia.cources;

import com.itclopedia.cources.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                sessionFactory = new Configuration()
                        .addAnnotatedClass(Answer.class)
                        .addAnnotatedClass(Articles.class)
                        .addAnnotatedClass(Categories.class)
                        .addAnnotatedClass(Comments.class)
                        .addAnnotatedClass(PostTag.class)
                        .addAnnotatedClass(Questions.class)
                        .addAnnotatedClass(Roles.class)
                        .addAnnotatedClass(Surveys.class)
                        .addAnnotatedClass(Tag.class)
                        .addAnnotatedClass(User.class)
                        .addAnnotatedClass(UserRole.class)
                        .buildSessionFactory();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        return sessionFactory;
    }
}
