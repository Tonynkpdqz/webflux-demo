package com.nkpdqz.webfluxdemo.DAO;

import com.nkpdqz.webfluxdemo.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO{

    @Override
    public User getUserByName(String username) {
        return new User(1L,"nkpdqz","nkpdqz_good","nl@nkpdqz.com");
    }

    @Override
    public int addUser(User user) {
        System.out.println("执行入库操作");
        return 1;
    }
}
