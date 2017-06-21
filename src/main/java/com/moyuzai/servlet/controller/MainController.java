package com.moyuzai.servlet.controller;

import com.moyuzai.servlet.dto.LoginResponse;
import com.moyuzai.servlet.enums.LoginStateEnum;
import org.slf4j.Logger;
import com.moyuzai.servlet.entity.User;
import com.moyuzai.servlet.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by kong on 17-6-19.
 */
@Controller
@RequestMapping("/users")
public class MainController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/id/{id}",method = RequestMethod.GET)
    public LoginResponse queryUserById(@PathVariable(value = "id") long id){
        LoginResponse response;
        logger.info("按ID查询用户。。");
        User user = userService.getUserById(id);
        if (user==null||"".equals(user)){
            response = new LoginResponse(false, LoginStateEnum.NOT_FOUND);
        }else {
            response = new LoginResponse(true, user);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> queryAllUsers(){
        logger.info("查询所有用户。。");
        List<User> users = userService.getAllUsers();
        return users;
    }

    @ResponseBody
    @RequestMapping(value = "/mobile/{mobile}",method = RequestMethod.GET)
    public User queryUserByMobile(@PathVariable(value = "mobile") String mobile){
        logger.info("按手机号码查询用户。。");
        User user = userService.getUserByMobile(mobile);
        return user;
    }


}
