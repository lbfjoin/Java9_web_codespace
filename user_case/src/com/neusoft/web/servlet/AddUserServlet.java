package com.neusoft.web.servlet;

import com.neusoft.domain.User;
import com.neusoft.service.Impl.UserServiceImpl;
import com.neusoft.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @author lbf
 * @date 2020/9/1 8:50
 */
@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取参数
        // "name" : zhangsan
        Map<String, String[]> map = req.getParameterMap();

//        String name = req.getParameter("name");
//        String sex = req.getParameter("sex");
//        String age1 = req.getParameter("age");
//        int age = Integer.parseInt(age1);
//        String address = req.getParameter("address");
//        String qq = req.getParameter("qq");
//        String email = req.getParameter("email");
        //3.封装成对象
        User user = new User();
//        user.setName(name);
//        user.setGender(sex);
//        user.setAge(age);
//        user.setEmail(email);
//        user.setAddress(address);
//        user.setQq(qq);
        try {
//            commons
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用service方法 add方法
        UserServiceImpl service = new UserServiceImpl();
        service.addUser(user);
        //5.重定向到list.jsp
        resp.sendRedirect(req.getContextPath() + "/findUserByPageServlet");
    }

}
