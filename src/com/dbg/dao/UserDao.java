package com.dbg.dao;

import com.dbg.entity.UserDB;
import com.dbg.utils.C3p0Tool;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;


import java.sql.SQLException;

/**
 * @author 15968
 * @version 1.0
 * @description: 用户的数据连接层
 * @date 2023/9/30 20:58
 */

public class UserDao {

    QueryRunner queryRunner = new QueryRunner(C3p0Tool.getDataSource());
    // 开启驼峰自动转换
    BeanProcessor bean = new GenerousBeanProcessor();
    RowProcessor processor = new BasicRowProcessor(bean);

    /**
     * @description: 用户登录
     * @author 15968
     * @date 2023/10/1 13:43
     * @version 1.0
     */
    public UserDB login(String account, String password) {
        String sql = "select * from t_user where account = ? and password = ?";
        Object[] params = {account, password};
        try {
            return queryRunner.query(sql, new BeanHandler<UserDB>(UserDB.class, processor), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @description: 删除用户
     * @author 15968
     * @date 2023/9/30 22:31
     * @version 1.0
     */
    public int delUser(Integer uid) {
        String sql = "delete from t_user where uid = ?";
        Object[] params = {uid};
        try {
            // int i = queryRunner.update(sql, params);
            return queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
