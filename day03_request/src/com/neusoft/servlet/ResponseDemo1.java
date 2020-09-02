package com.neusoft.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author lbf
 * @date 2020/8/26 9:45
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo1……");
        //重定向
//       //  方法一（不常用）：设置状态码是302
//        resp.setStatus(302);
////        //设置响应头 location
//        resp.setHeader("location","/responseDemo2");

        //方式二：  这个方法获取不到值 结果为null ,但是可以跳转到特定网址
//        req.setAttribute("mgs", "response_success");
//        resp.sendRedirect("/responseDemo2");

        resp.sendRedirect("http://www.baidu.com");

    }
}
