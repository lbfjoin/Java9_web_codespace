package com.neusoft.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lbf
 * @date 2020/8/26 11:04
 */
@WebServlet("/demo4")
//    @WebServlet({"/d4","/dd4","/ddd4"})   //同时配置多个servlet路径
//    @WebServlet("/protal/demo4")  //多层路径
//    @WebServlet("/start/*")     //start后面加任何字符都可以运行
//    @WebServlet("*.do")    //扩展名匹配  以 .do结尾就可以
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4被调用");
    }
}
