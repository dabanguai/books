package com.dbg.service;

import com.dbg.dao.UserDao;
import com.dbg.entity.UserDB;

/**
 * @author 15968
 * @version 1.0
 * @description: 用户业务层
 * @date 2023/10/1 13:51
 */
public class UserService {

    private UserDao userDao = new UserDao();

    /**
     * @description: 登录
     * @author 15968
     * @date 2023/10/1 21:23
     * @version 1.0
     */
    public UserDB login(String account, String password) {
        return userDao.login(account, password);
    }
}
