package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class userServlet extends baseServlet {
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("user selectall");
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("user add");
    }

}
