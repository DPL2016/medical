package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import com.kaishengit.pojo.UserLog;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Source;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
public class UserDao{
    @Inject
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public User findByUserName(String username) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username",username));

        return (User) criteria.uniqueResult();
    }


    public List<User> findAll() {
        Criteria criteria = getSession().createCriteria(User.class);
        return criteria.list();
    }

    public User findById(Integer id){
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id",id));
        return (User) criteria.uniqueResult();
    }

    public void delete(Integer id) {
        getSession().delete(findById(id));
    }

    public void save(User user) {
        getSession().saveOrUpdate(user);
    }


    public Long count() {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    public void update(Integer id) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id",id));
        User user =  (User) criteria.uniqueResult();
        getSession().update(user);
    }

}
