package com.neusoft.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lbf
 * @date 2020/8/29 14:07
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //1.设置request编码
        req.setCharacterEncoding("utf-8");
        //2.获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        //3.先获取预先生成好的验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //4.删除session中的验证码
        session.removeAttribute("checkCode_session");
        //5.先判断验证码是否正确
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            //判断用户名和密码是否正确
            if ("zhangsan".equals(username) && "123".equals(password)){//TODO 调用UserDao查询数据库
                //登陆成功
                //将用户的信息存储到session里面
                session.setAttribute("user",username);

                // 重定向到success页面
                resp.sendRedirect(req.getContextPath() + "/success.jsp");
            }else {
                //登陆失败
                req.setAttribute("login_error","用户名或者密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }else {
            //验证码不一致
            req.setAttribute("cc_error","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }


    }
}
