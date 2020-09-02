package com.neusoft.request;

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
@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //演示获取请求头数据
        Enumeration<String> headerNames = req.getHeaderNames();
        //遍历
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            //根据名字获取请求头值
            String value = req.getHeader(name);
            System.out.println(name + "=====>"+value);
        }

        String header = req.getHeader("user-agent");
        if (header.contains("Chrome")){
            System.out.println("你用的是谷歌");
        }else if (header.contains("Firefox")){
            System.out.println("你用的是火狐");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
