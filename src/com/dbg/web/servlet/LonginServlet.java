package com.dbg.web.servlet;

import com.dbg.entity.UserDB;
import com.dbg.service.UserService;
import com.dbg.utils.MD5;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author 15968
 * @version 1.0
 * @description: TODO
 * @date 2023/9/30 13:18
 */

@WebServlet("/login")
public class LonginServlet extends BaseServlet{

    private static final long serialVersionUID = 1L;

    private UserService userService = new UserService();

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        UserDB userDB = userService.login(account, MD5.valueOf(password));
        if (userDB == null) {
        //    账号密码错误
            request.setAttribute("msg", "账号密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            // 登录成功
            session.setAttribute("userDB", userDB);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
