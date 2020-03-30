package com.nkpdqz.webfluxdemo.Service;

import com.nkpdqz.webfluxdemo.DAO.UserDAO;
import com.nkpdqz.webfluxdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;

    @Override
    public User getUserByName(String name) {
        return dao.getUserByName(name);
    }

    @Override
    public int addUser(User user) {
        return dao.addUser(user);
    }
}
