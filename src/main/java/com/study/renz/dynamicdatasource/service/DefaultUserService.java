package com.study.renz.dynamicdatasource.service;

import com.study.renz.dynamicdatasource.entity.User;
import com.study.renz.dynamicdatasource.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by renz on 2018/7/9.
 */
@Service
//@Transactional
public class DefaultUserService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void insert() {
        for (int age = 25; age < 35; age++) {
            User user = new User();
            user.setAge(age);
            user.setName("renz");
            user.setAddress("chengdu");
            userRepository.insertUser(user);
        }
    }
}
