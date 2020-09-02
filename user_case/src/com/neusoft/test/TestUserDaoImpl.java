package com.neusoft.test;

import com.neusoft.dao.Impl.UserDaoImpl;
import com.neusoft.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * @author lbf
 * @date 2020/8/31 15:11
 */
public class TestUserDaoImpl {
    @Test
    public void userDaoImplTest() {
        UserDaoImpl dao = new UserDaoImpl();
        List<User> users = dao.fingAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void test2(){
        User user = new User();
        user.setName("hhh");
        user.setGender("男");
        user.setAge(22);
        user.setAddress("大连");
        user.setQq("123456");
        user.setEmail("123456@qq.com");
        UserDaoImpl dao = new UserDaoImpl();
        dao.add(user);
    }
    @Test
    public void test3() throws InvocationTargetException, IllegalAccessException {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age","12");
        User user = new User();
        BeanUtils.populate(user,map);

        System.out.println(user);
    }
    @Test
    public void test4(){
//        UserDaoImpl dao = new UserDaoImpl();
//        dao.remove();
    }
    @Test
    public void test5(){
        User user = new User();
        user.setId(18);
        user.setGender("女");
        UserDaoImpl dao = new UserDaoImpl();
        dao.update(user);
    }
    @Test
    public void test6(){
        UserDaoImpl dao = new UserDaoImpl();
        User user = dao.findUserByUsernameAndPassword("eric", "123");
        System.out.println(user);
    }
}
