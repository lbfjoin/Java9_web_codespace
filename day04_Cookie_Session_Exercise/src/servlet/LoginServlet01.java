package servlet;

import dao.Impl.UserDaoImpl;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author lbf
 * @date 2020/8/30 22:52
 */
@WebServlet("/loginServlet01")
public class LoginServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");

        session.removeAttribute("checkCode_session");

        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            User user = new User();
            UserDaoImpl dao = new UserDaoImpl();
            user.setUsrname(username);
            user.setPassword(password);
            try {
                dao.login(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (dao.login(user) != null){
                    session.setAttribute("user",username);
                    resp.sendRedirect(req.getContextPath() +"/success.jsp");
                }
                else {
                    req.setAttribute("login_error","账号名或者密码错误");
                    req.getRequestDispatcher("/login.jsp").forward(req,resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            req.setAttribute("cc_error","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
