package com.moyuzai.servlet.dao;

import com.moyuzai.servlet.entity.User;

import java.util.List;

/**
 * Created by kong on 17-6-20.
 */
public interface UserDao {

    User queryById(long id);

    User queryByMobile(String mobile);

    List<User> queryAll();


}
