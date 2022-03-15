package com.example;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("download...");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        String fileName = request.getParameter("fileName");
        if (fileName == null || "".equals(fileName.trim())){
            response.getWriter().write("please enter the fileName to download!");
            response.getWriter().close();
            return;
        }
        //get location
        String path = request.getServletContext().getRealPath("/");
        //use location to get file
        File file = new File(path+fileName);
        if (file.exists()&&file.isFile()){
            //set response content type-->application/octet-stream or application/x-msdownload
            response.setContentType("applicaton/x-msdownload");
            //header-->
            response.setHeader("Content-Disposition","attachment;filename="+fileName);
            //get inputstream
            InputStream is = new FileInputStream(file);
            ServletOutputStream out = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length=is.read(bytes)) != -1){
                out.write(bytes,0,length);
            }
            //close
            out.close();
            is.close();

        }else {
            response.getWriter().write("File doesn't exist, enter again");
            response.getWriter().close();
        }
    }
}
