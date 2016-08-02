package com.kaishengit.dao;

import com.kaishengit.pojo.UserLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
public class UserLogDao {
    @Inject
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public void save(UserLog userLog) {
        getSession().save(userLog);
    }

}
