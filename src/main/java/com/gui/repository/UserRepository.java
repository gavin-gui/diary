package com.gui.repository;

import com.gui.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserName(String userName);

    User findByUserNameAndPassword(User user);

}
