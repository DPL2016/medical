package com.kaishengit.service;

import com.kaishengit.dao.RoleDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.dao.UserLogDao;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import com.kaishengit.pojo.UserLog;
import com.kaishengit.util.ShiroUtil;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class UserService {

    @Inject
    private UserLogDao userLogDao;

    @Inject
    private RoleDao roleDao;

    @Inject
    private UserDao userDao;

    public void saveUserLogin(String ip) {
        UserLog userLog = new UserLog();
        userLog.setLoginip(ip);
        userLog.setLogintime(DateTime.now().toString("yyyy-MM-dd HH:mm"));
        User user = ShiroUtil.getCurrentUser();
        userLog.setUser(user);
        userLogDao.save(userLog);
    }

    public Role findUserById(Integer roleId) {
        return roleDao.findById(roleId);
    }

    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void deleteUser(Integer id) {
        userDao.delete(id);
    }
}
