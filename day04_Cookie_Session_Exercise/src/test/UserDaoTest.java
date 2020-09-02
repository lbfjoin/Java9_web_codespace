package test;

import dao.Impl.UserDaoImpl;
import domain.User;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author lbf
 * @date 2020/8/30 9:48
 */
public class UserDaoTest {
    @Test
    public void test() throws SQLException {
        User loginuser = new User();
        UserDaoImpl dao = new UserDaoImpl();
        loginuser.setUsrname("lisi");
        loginuser.setPassword("123");
        System.out.println(dao.login(loginuser));
    }
}
