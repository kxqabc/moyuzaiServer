package com.moyuzai.servlet.controller;

import com.moyuzai.servlet.dao.UserDao;
import com.moyuzai.servlet.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by kong on 17-6-19.
 */
@Controller
public class MainController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User queryUserById(@Param(value = "id") long id){
        User user = userDao.queryById(id);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public List<User> queryAllUsers(){
        List<User> users = userDao.queryAll();
        return users;
    }
}
