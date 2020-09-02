package com.neusoft.dao;

import com.neusoft.domain.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author lbf
 * @date 2020/8/31 14:41
 */
public interface UserDao {
    //用户操作dao
    public List<User> fingAll();

    void add(User user);

    void remove(int id);

    void update(User user);

    User findById(int id);

    User findUserByUsernameAndPassword (String username,String password);

    /*
    * 查询总记录数
    * */
   int findTotalCount(Map<String,String[]> condition);

    /**
     * 分页查询每页记录
     * */
    List<User> findByPage(int start, int rows, Map<String,String[]> condition);
}
