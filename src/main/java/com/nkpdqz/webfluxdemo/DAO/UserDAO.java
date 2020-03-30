package com.nkpdqz.webfluxdemo.DAO;

import com.nkpdqz.webfluxdemo.pojo.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDAO {

    User getUserByName(String username);
    int addUser(User user);
}
