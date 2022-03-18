package com.project.controller;

import com.project.entity.valueObject.MessageModel;
import com.project.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        MessageModel messageModel = userService.userLogin(uname,pwd);
        if (messageModel.getCode() == 1){
            request.getSession().setAttribute("user",messageModel.getObject());
            response.sendRedirect("uploader.html");
        }else {
            request.setAttribute("messageModel",messageModel);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        System.out.println(uname);
    }
}
