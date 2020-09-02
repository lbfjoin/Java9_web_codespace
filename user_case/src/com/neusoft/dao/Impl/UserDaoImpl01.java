package com.neusoft.dao.Impl;

import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;
import com.neusoft.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lbf
 * @date 2020/9/2 20:15
 */
public class UserDaoImpl01 implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> fingAll() {
        String sql = "select * from user ";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));

    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null ,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void remove(int id) {
        template.update("delete from user where id =?",id);
    }

    @Override
    public void update(User user) {
        template.update("update user set name=?, gender =?,age=?,address=?,qq=?,email=? where id =?",user.getName(),user.getGender(),
                user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try{
            String sql = "select * from user where username=? and password =?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select * from user where 1 =1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> KeySet = condition.keySet();

        return 0;
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {

        String sql = "select * from user where 1= 1  ";
//        String sql = "select * from user  limit ?,?";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
//
        List<Object> params = new ArrayList<>();

        for (String key :keySet){
            // 排除 分页的条件参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
//            SELECT count(*) FROM user WHERE 1=1 AND name LIKE '%李%'
            // 获取value值
            String value = condition.get(key)[0];
            // 判断value是否有值
            if (value !=null && !"".equals(value)){
                sb.append("  and "+ key +"  like ?  ");
                params.add("%" + value+"%");
            }
        }
//        // 添加分页
        sb.append("   limit ?,? ");
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println("sqlfindByPage"+sql);
        System.out.println("params"+params);


//        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }


}