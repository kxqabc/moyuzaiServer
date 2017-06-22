package com.moyuzai.servlet.service;

import com.moyuzai.servlet.dto.UsersResponse;
import com.moyuzai.servlet.entity.User;
import com.moyuzai.servlet.enums.UsersEnum;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by xiang on 2017/6/21.
 */
public interface UserService {

    User getUserById(long id);

    User getUserByMobile(String mobile);

    List<User> getAllUsers();

    UsersEnum updatePasswordByMobile(String mobile, String newPassword);

}
