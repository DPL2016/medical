package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserDao{
    @Inject
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public User findByUserName(String username) {
        return (User) getSession().get(User.class,username);
    }
}
