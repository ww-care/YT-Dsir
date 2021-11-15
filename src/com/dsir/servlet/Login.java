package com.dsir.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Project_Name 移通代sir
 * @Author Ww-Care
 * @Date 2021/11/15 11:31
 * @Version 1.0
 **/
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputUsername = req.getParameter("username");
        String inputPassword = req.getParameter("password");
        //数据库查询用户名和密码

        //对比用户名和密码
        if (inputPassword.equals("")) {
            //转发用户请求
            //create a session
            HttpSession session = req.getSession();
            //set userinfo to session
            session.setAttribute("username", inputUsername);
            req.getRequestDispatcher("main.html").forward(req, resp);
        } else {
            //重定向
            resp.sendRedirect("login.html?login=fail");
        }
    }
}
