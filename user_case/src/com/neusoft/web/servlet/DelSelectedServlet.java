package com.neusoft.web.servlet;

import com.neusoft.service.Impl.UserServiceImpl;
import com.neusoft.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author lbf
 * @date 2020/8/31 14:25
 */
@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //获取所有选中的 uid
        String[] uids = req.getParameterValues("uid");

        System.out.println(Arrays.toString(uids));
        System.out.println("dsd00");
        UserServiceImpl service = new UserServiceImpl();
        service.deleteSelectedUser(uids);
        //重定向
        resp.sendRedirect(req.getContextPath() + "/findUserByPageServlet");
    }
}
