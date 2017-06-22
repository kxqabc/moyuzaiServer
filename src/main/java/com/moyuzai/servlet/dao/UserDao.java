package com.moyuzai.servlet.dao;

import com.moyuzai.servlet.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by kong on 17-6-20.
 */
public interface UserDao {

    /**查找*/
    User queryById(long id);

    User queryByMobile(String mobile);

    List<User> queryAll();

    /**修改*/
    int updateByMobile(@Param(value = "mobile") String mobile, @Param(value = "password") String password);





}
