package com.dbg.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 15968
 * @version 1.0
 * @description: 所有的Servlet都要继承此类
 * @date 2023/9/28 16:16
 */
public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //    设置编码
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
            //    获取类
            Class<? extends BaseServlet> clazz = this.getClass();
            //    获取方法名
            String parameter = req.getParameter("method");
            //    获取要执行的方法
            Method method = clazz.getDeclaredMethod(parameter, HttpServletRequest.class, HttpServletResponse.class);
            //    考虑到方法的权限问题
            method.setAccessible(true);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("baseServlet");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
