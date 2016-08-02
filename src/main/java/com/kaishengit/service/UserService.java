package com.kaishengit.service;

import com.kaishengit.dao.RoleDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.dao.UserLogDao;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import com.kaishengit.pojo.UserLog;
import com.kaishengit.util.ShiroUtil;
import com.kaishengit.util.Strings;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

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

    public Role findUserByRoleId(Integer roleId) {
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

    public void saveUser(User user) {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        user.setEnable(true);
        user.setPinyin(Strings.toPinyin(user.getRealname()));
        userDao.save(user);
    }

    public List<Role> findAllRole() {
        return roleDao.findAll();
    }

    public Long countUser() {
        return userDao.count();
    }

    public User finById(Integer id) {
        return userDao.findById(id);
    }

    public void updateUserDisable(Integer id) {
        User user = userDao.findById(id);
        user.setEnable(false);
        userDao.save(user);
    }

    public void editUser(User user) {

    }
}
