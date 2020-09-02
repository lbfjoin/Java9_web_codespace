package com.neusoft.service.Impl;

import com.neusoft.dao.Impl.UserDaoImpl;
import com.neusoft.dao.UserDao;
import com.neusoft.domain.PageBean;
import com.neusoft.domain.User;
import com.neusoft.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author lbf
 * @date 2020/8/31 14:47
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> finaAll() {

        //调用dao
        return dao.fingAll();

    }

    @Override
    public void addUser(User user) {
        //添加用户
        dao.add(user);
    }

    @Override
    public void removeUser(String id) {
        dao.remove(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void deleteSelectedUser(String[] ids) {
        //根据id批量删除数据
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                dao.remove(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition){
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0){
            currentPage = 1;
        }
        // 创建 PageBean对象
        PageBean<User> pb = new PageBean();
        // 设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        // 调用dao 的 查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        // 调用 dao 分页查询
        int start = (currentPage-1)*rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);
        // 计算总页码
        int totalPage = (totalCount%rows) == 0? totalCount/rows : totalCount/rows +1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
