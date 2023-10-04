package com.dbg.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 15968
 * @version 1.0
 * @description: C3p0工具类
 * @date 2023/9/30 20:32
 */
public class C3p0Tool {

    private static DataSource dataSource = new ComboPooledDataSource();

    /**
     * @description: 获取数据源
     * @author 15968
     * @date 2023/9/30 20:54
     * @version 1.0
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * @description: 获取连接
     * @author 15968
     * @date 2023/9/30 20:54
     * @version 1.0
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
