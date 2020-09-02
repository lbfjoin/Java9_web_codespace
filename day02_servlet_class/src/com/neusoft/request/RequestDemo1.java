package com.neusoft.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lbf
 * @date 2020/8/26 9:45
 */
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求方式： GET
        String method = req.getMethod();
        System.out.println("method" + method); // GET

        // 2 获取虚拟目录
        String contextPath = req.getContextPath(); // xixi
        System.out.println("contextPath" + contextPath);    //虚拟目录 Deployment中的Application context中的路径

        // 3.获取servlet路径
        String servletPath = req.getServletPath();
        System.out.println("servletPath" + servletPath); // requestDemo1

        // 4. 获取get方式的请求参数
        String queryString = req.getQueryString();
        // http://localhost/requestDemo1?name=lihuizhang
        // name=lihuizhang
        // queryStringname=lihuizhang&age=female
        System.out.println("queryString" + queryString);

        // 5. 获取 URI
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURI" + requestURI);
        // /requestDemo1 像 共和国
        System.out.println("requestURL" + requestURL);
        // http://localhost/requestDemo1   像中华人民共和国
        // 6. 获取协议版本
        String protocol = req.getProtocol(); // HTTP/1.1
        System.out.println("protocol"+protocol);
        // 7.获取客户机iP地址  0:0:0:0:0:0:0:1
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr"+remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
