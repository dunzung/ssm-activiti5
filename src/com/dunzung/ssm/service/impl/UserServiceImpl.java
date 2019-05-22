package com.dunzung.ssm.service.impl;

import com.dunzung.ssm.entity.UserEntity;
import com.dunzung.ssm.mapper.UserMapper;
import com.dunzung.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhijund on 2019/5/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity getUserById(String uid) {
        return userMapper.get(uid);
    }
}
