package com.easy.archiecture;

import com.easy.archiecture.model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2025/8/17 11:03
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String userAge = req.getParameter("userage");
        User user = new User();
        user.setUserAge(Integer.valueOf(userAge));
        user.setUsername(username);
        //调用数据库接口保存数据
    }

    /*
    1、javaweb开发的HTTP标准，
    2、filter
    3、listener
     */
}
