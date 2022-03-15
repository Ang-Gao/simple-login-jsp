package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
//action 一致
@WebServlet("/uploadServlet")
//文件上传需要设置此注解
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("uploading...");
        //encode
        request.setCharacterEncoding("UTF-8");
        //get username of form
        String username = request.getParameter("username");
        System.out.println("username: "+username);
        //get Part object
        //HttpServletRequest request;
        Part part = request.getPart("myFile");
        //use part object to get name of file
        String fileName = part.getSubmittedFileName();
        System.out.println("fileName: "+fileName);
        //get path of the file
        String filePath = request.getServletContext().getRealPath("/");
        part.write(filePath+"/"+fileName);
        //GET PATH
        System.out.println(filePath);
        response.sendRedirect("http://baidu.com");
    }
}
