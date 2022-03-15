package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //receive parameters
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        //judge parameters..
        if (username == null || "".equals(username.trim())){
            request.setAttribute("msg","用户信息不能为空");
            request.getRequestDispatcher("01-JSP.jsp").forward(request,response);
            return;
        }
        if (passwd == null || "".equals(passwd.trim())){
            request.setAttribute("msg","密码不能为空");
            request.getRequestDispatcher("01-JSP.jsp").forward(request,response);
            return;
        }
        if (!username.equals("admin") || !passwd.equals("abc123")){
            request.setAttribute("msg","账户或密码不正确");
            request.getRequestDispatcher("01-JSP.jsp").forward(request,response);
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("登陆成功！");
        //session的域对象可以让访问别的窗口也是知道用户是admin
        request.getSession().setAttribute("uname",username);
    }
}
