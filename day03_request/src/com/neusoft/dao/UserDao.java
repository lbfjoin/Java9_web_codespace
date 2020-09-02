package com.neusoft.dao;

import com.neusoft.domain.User;

import java.sql.SQLException;

/**
 * @author lbf
 * @date 2020/8/28 10:24
 */
public interface UserDao {
    public User login(User loginUser) throws SQLException;


}
