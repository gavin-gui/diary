package com.gui.controller;

import com.gui.exception.TipException;
import com.gui.model.User;
import com.gui.service.UserService;
import com.gui.utils.DateKit;
import com.gui.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/15.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session) {
        try {
            User user1 = userService.login(user);
            session.setAttribute(user1.getId()+"",user1);
            return "index";
        } catch (TipException e) {
            model.addAttribute("errMsg",e.getErrMsg());
        }
        return "login";
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registry(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
        //检查用户是否已存在
        boolean isExists = userService.checkUserExists(userName);
        //如果用户存在，返回注册页面
        if(isExists) {
            model.addAttribute("errMsg","用户名已存在");
            return "register";
        }

        //保存用户信息
        User user = new User();
        user.setUserName(userName);
        user.setPassword(Md5Utils.md5(password));
        Date now = new Date();
        user.setCreateDate(DateKit.format(now));
        user.setUpdateDate(DateKit.format(now));
        userService.saveUser(user);
        //跳转到登录页面
        return "login";
    }

}
