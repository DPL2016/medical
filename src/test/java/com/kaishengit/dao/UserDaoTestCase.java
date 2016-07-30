package com.kaishengit.dao;


import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.TypeNames;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class UserDaoTestCase {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private RoleDao roleDao;
    @Test
    public void testFindByUsername(){
       User user = userDao.findByUserName("tom");
        System.out.println(user);
    }

    @Test
    public void testFindByRoleid(){
        Role role = roleDao.findById(1);
        System.out.println(role);
    }

}
