package com.sszh.base.service.impl;

import com.sszh.base.mapper.UserMapper;
import com.sszh.base.mapper.domain.UserDO;
import com.sszh.base.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WangJianGuo
 * @Title: UserServiceImpl
 * @Package com.sszh.base.service.impl
 * @Description: 用户服务实现类
 * @date 2018/3/30/030 10:47
 */
@Log4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDO findById(int id) {
        log.info("findById服务层开启工作");
        UserDO user;
        user = userMapper.getUserById(id);
        log.info(userMapper.getUserById(id).toString());
        return user;
    }
}