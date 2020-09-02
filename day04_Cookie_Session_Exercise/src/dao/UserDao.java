package dao;

import domain.User;

import java.sql.SQLException;

public interface UserDao {
    public User login(User loginUser) throws SQLException;
}
