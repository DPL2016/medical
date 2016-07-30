package com.kaishengit.controller;

import com.kaishengit.pojo.User;
import com.kaishengit.pojo.UserLog;
import com.kaishengit.service.AccountService;
import com.kaishengit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
    @Inject
    private UserService userService;

    /**
     *显示用户列表
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        List<User> userList = userService.findAll();

        model.addAttribute("userList",userList);
        return "settings/account/list";
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/{id:\\d+}/del",method = RequestMethod.GET)
    public String del(@PathVariable Integer id){
        userService.deleteUser(id);
        return "redirect:account";
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String save(){
        return "settings/account/new";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String save(User user){

        return "redirect:account";
    }

}
