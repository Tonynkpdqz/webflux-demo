package com.nkpdqz.webfluxdemo.Service;

import com.nkpdqz.webfluxdemo.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUserByName(String name);
    int addUser(User user);
}
