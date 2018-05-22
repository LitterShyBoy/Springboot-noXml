package com.sszh.base.service;

import com.sszh.base.mapper.domain.UserDO;
import org.springframework.stereotype.Service;

/**
 * @author WangJianGuo
 * @Title: UserService
 * @Package com.sszh.base.service
 * @Description: 用户服务
 * @date 2018/3/30/030 10:45
 */
@Service
public interface UserService {
    /**
     *  根据id查询
     * @return UserDO
     * @Description: 通过ID寻找User
     * @author WangJianGuo
     * @date 2018/3/8/008 10:09
     * @param id
     */
    UserDO findById(int id);
}