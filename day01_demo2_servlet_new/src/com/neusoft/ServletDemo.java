package com.neusoft;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author lbf
 * @date 2020/8/25 16:48
 */
@WebServlet("/demo3")
//@WebServlet(urlPatterns = "/demo3")
//通过构造函数创建servlet对象
public class ServletDemo implements Servlet {
    //初始化servlet对象
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //访问url需要servlet提供服务，执行servlet方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service3.0厉害啊");
        int a = 100;
        int b = 1000;
        int c = 0;
        System.out.println(a + b);
        System.out.println(a/c);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //在重启和关闭时自动对servlet进行销毁
    @Override
    public void destroy() {

    }
}
