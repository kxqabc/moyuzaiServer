package com.moyuzai.servlet.service;

import com.moyuzai.servlet.dao.UserDao;
import com.moyuzai.servlet.dto.BaseResponse;
import com.moyuzai.servlet.dto.UsersResponse;
import com.moyuzai.servlet.entity.User;
import com.moyuzai.servlet.enums.UsersEnum;
import org.apache.taglibs.standard.lang.jstl.ELEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by xiang on 2017/6/21.
 */
@Service
public class UserServiceImpl implements UserService{
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(long id) {
        User user = userDao.queryById(id);
        return user;
    }

    @Override
    public User getUserByMobile(String mobile) {
        User user = userDao.queryByMobile(mobile);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.queryAll();
        return users;
    }

    @Override
    public UsersEnum updatePasswordByMobile(String mobile, String newPassword) {
        User user = userDao.queryByMobile(mobile);
        if (user==null||"".equals(user)){
            return UsersEnum.NOT_FOUND;
        }
        int result = userDao.updateByMobile(mobile,newPassword);//result代表的是被影响的记录的个数
        if (result>0){
            return UsersEnum.MODIFY_SUCCESS;
        }else {
            return UsersEnum.MODIFY_ERROR;
        }
    }

}
