package com.kaishengit.dao;


import com.kaishengit.pojo.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

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
        Criteria criteria = getSession().createCriteria(Role.class);
        criteria.add(Restrictions.eq("id",roleId));
        Role role = (Role) criteria.uniqueResult();
        System.out.println(role);
        return role;
    }
}
