package dao.Impl;

import dao.UserDao;
import domain.User;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lbf
 * @date 2020/8/30 9:20
 */
public class UserDaoImpl implements UserDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    User user = null;
    @Override
    public User login(User loginUser) throws SQLException {
        String sql = "select * from userlogin where username =? and password =?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,loginUser.getUsrname());
            pstmt.setString(2,loginUser.getPassword());
            rs = pstmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUsrname(rs.getString(2));
                user.setPassword(rs.getString(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return user;
    }
}
