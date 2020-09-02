package com.neusoft.test;

import com.neusoft.dao.Impl.UserDaoImpl;
import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;

import java.sql.SQLException;

import org.junit.Test;

/**
 * @author lbf
 * @date 2020/8/28 10:42
 */
public class UserDaoTest {
    @Test
    public void test() throws SQLException {
        User loginUser = new User();
        loginUser.setUsername("bigbaby");
        loginUser.setPassword("123456");

        UserDao dao = new UserDaoImpl();
        User user = dao.login(loginUser);
        System.out.println(user);

    }
}
