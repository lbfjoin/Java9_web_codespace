package com.neusoft.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lbf
 * @date 2020/8/29 10:33
 */
@WebServlet("/cookieTest02")
public class CookieTest02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        if (cookies.length > 0 && cookies != null){
            for (Cookie cookie : cookies){
                String name = cookie.getName();
                if ("lastTime".equals(name)){
                    flag = true;
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);

                    System.out.println("编码前str_date" + str_date);
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后str_date" + str_date);

                    cookie.setValue(str_date);
                    cookie.setMaxAge(60*60*24*30);
                    resp.addCookie(cookie);
                }
            }
        }
    }
}
