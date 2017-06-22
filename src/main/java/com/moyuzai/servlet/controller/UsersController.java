package com.moyuzai.servlet.controller;

import com.moyuzai.servlet.dto.BaseResponse;
import com.moyuzai.servlet.dto.UsersResponse;
import com.moyuzai.servlet.enums.UsersEnum;
import org.slf4j.Logger;
import com.moyuzai.servlet.entity.User;
import com.moyuzai.servlet.service.UserService;
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
public class UsersController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private BaseResponse response;

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/id/{id}",method = RequestMethod.GET)
    public BaseResponse queryUserById(@PathVariable(value = "id") long id){
        logger.info("按ID查询用户。。");
        User user = userService.getUserById(id);
        response = Binding.bindingGetResult(user);
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseResponse queryAllUsers(){
        logger.info("查询所有用户。。");
        List<User> users= userService.getAllUsers();
        response = Binding.bindingGetResult(users);
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/mobile/{mobile}",method = RequestMethod.GET)
    public BaseResponse queryUserByMobile(@PathVariable(value = "mobile") String mobile){
        logger.info("按手机号码查询用户。。");
        User user = userService.getUserByMobile(mobile);
        response = Binding.bindingGetResult(user);
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/mobile/{mobile}/pw/{password}",method = RequestMethod.POST)
    public BaseResponse modifyPassword(@PathVariable(value = "mobile") String mobile,
                                       @PathVariable(value = "password")String password){
        response = new UsersResponse(userService.updatePasswordByMobile(mobile,password));
        logger.info("updateResult="+response);
        return response;
    }


    /**讲service的结果转换为dto.response*/
    private static class Binding{

        public static UsersResponse bindingGetResult(User user){
            if (user==null||"".equals(user)){
                return new UsersResponse(UsersEnum.NOT_FOUND);
            }else {
                return new UsersResponse(UsersEnum.GET_SUCCESS, user);
            }
        }

        public static UsersResponse bindingGetResult(List<User> users){
            if (users==null||"".equals(users)||users.size()==0)
                return new UsersResponse(UsersEnum.NOT_FOUND);
            else
                return new UsersResponse(UsersEnum.GET_SUCCESS,users);
        }

    }



}
