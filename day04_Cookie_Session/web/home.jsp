<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: lbf
  Date: 2020/8/29
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%   /**
 *  有：不是第一次访问
 *  没哟， 是第一次
 */
    response.setContentType("text/html;charset=utf-8");
    // 1. 获取所有cookie
    Cookie[] cookies = request.getCookies();
    boolean flag = false; // 表示有没有 cookie 为 lastTime
    // 2. 遍历cookie数组
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            // 获取cookie的名称
            String name = cookie.getName();
            // 判断变量的cookie 是否 为 lastTime
            if ("lastTime".equals(name)) {
                // 响应数据
                String value = cookie.getValue();
                //  有 不是第一次
                flag = true;
                // 获取当前时间
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = sdf.format(date);
                System.out.println("编码前str_date" + str_date);
                // URL 编码
                str_date = URLEncoder.encode(str_date, "utf-8");
                System.out.println("编码后str_date" + str_date);

                cookie.setValue(str_date);
                cookie.setMaxAge(60 * 60 * 24 * 30);// 一个月
                response.addCookie(cookie);


                System.out.println("value解码前" + value);
                // URL 解码
                value = URLDecoder.decode(value, "utf-8");
                System.out.println("value解码后" + value);

                response.getWriter().write("<h1>欢迎回来， 您上次访问的时间是：" + value + "</h1>");
                break;
            }
        }
    }

    if (cookies == null || cookies.length == 0 || flag == false) {
        // 第一次访问
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);

        System.out.println("编码前str_date" + str_date);
        // URL 编码
        str_date = URLEncoder.encode(str_date, "utf-8");
        System.out.println("编码后str_date" + str_date);
        Cookie cookie = new Cookie("lastTime", str_date);
        cookie.setMaxAge(60 * 60 * 24 * 30);// 一个月
        response.addCookie(cookie);
        response.getWriter().write("<h1>您好，欢迎首次访问</h1>");
    }%>
<input type="text">
</body>
</html>
