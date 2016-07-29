package com.kaishengit.dao;


import com.kaishengit.pojo.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RoleDao{
    @Inject
    private SessionFactory sessionFactory;
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public Role findById(Integer roleId) {
        return (Role) getSession().get(Role.class,roleId);
    }
}
