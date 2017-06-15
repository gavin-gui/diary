package com.gui.service.impl;

import com.gui.exception.TipException;
import com.gui.model.User;
import com.gui.repository.UserRepository;
import com.gui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * Created by Administrator on 2017/6/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean checkUserExists(String userName) {
        return userRepository.findByUserName(userName) != null;
    }

    @Override
    public User saveUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public User login(User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        if(StringUtils.isEmpty(userName)) {
            throw new TipException("用户名不能为空");
        }

        if(StringUtils.isEmpty(password)) {
            throw new TipException("密码不能为空");
        }

        User user1 = userRepository.findByUserName(user.getUserName());
        if(!user1.getPassword().equals(password)) {
            throw new TipException("密码不能为空");
        }
        user1.setPassword(null);
        return user1;
    }
}
