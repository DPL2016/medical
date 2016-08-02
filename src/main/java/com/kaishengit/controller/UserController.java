package com.kaishengit.controller;

import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.User;
import com.kaishengit.pojo.UserLog;
import com.kaishengit.service.UserService;
import com.kaishengit.util.Page;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Inject
    private UserService userService;
    /**
     * 显示当前登录用户的登录日志
     * @return
     */
    @RequestMapping(value = "/log",method = RequestMethod.GET)
    public String showUserLog() {
        return "setting/loglist";
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/password",method = RequestMethod.GET)
    public String editPassword() {
        return "setting/password";
    }

    @RequestMapping(value = "/password",method = RequestMethod.POST)
    @ResponseBody
    public String editPassword(String password,String username) {
        userService.changePassword(password,username);
        return "success";
    }

    /**
     * 验证原始密码是否正确(Ajax调用)
     * @return
     */
    @RequestMapping(value = "/validate/password",method = RequestMethod.GET)
    @ResponseBody
    public String validateOldPassword(@RequestHeader("X-Requested-With") String xRequestedWith,
                                      String oldpassword) {
        if("XMLHttpRequest".equals(xRequestedWith)) {
            User user = ShiroUtil.getCurrentUser();
            if(user.getPassword().equals(DigestUtils.md5Hex(oldpassword))) {
                return "true";
            }
            return "false";
        } else {
            throw new NotFoundException();
        }
    }



}
