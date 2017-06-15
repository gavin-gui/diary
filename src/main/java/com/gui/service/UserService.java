package com.gui.service;

import com.gui.model.User;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface UserService {
    boolean checkUserExists(String userName);

    User saveUser(User user);

    User login(User user);
}
