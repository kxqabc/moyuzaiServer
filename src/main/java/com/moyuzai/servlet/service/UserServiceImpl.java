package com.moyuzai.servlet.service;

import com.moyuzai.servlet.dao.UserDao;
import com.moyuzai.servlet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiang on 2017/6/21.
 */
@Service
public class UserServiceImpl implements UserService{

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
}
