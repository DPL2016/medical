package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Source;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

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
        /*Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username",username));
        User user = (User) criteria.uniqueResult();
        System.out.println(user.getUsername());
        return user;*/
        String hql = "from User where username = :username";
        Query query = getSession().createSQLQuery(hql);
        query.setParameter("username",username);
        User user = (User) query.uniqueResult();
        System.out.println(user);
        return user;
    }
}
