package com.sszh.base.utils;


import com.sszh.base.mapper.domain.UserDO;

/**
 * @author WangJianGuo
 * @Title: GetToken
 * @Package com.sszh.pzycxw.utils
 * @Description: 测试类获得Token
 * @date 2018/3/26/026 16:33
 */
public class GetToken {
    public static UserDO getTokens(UserDO userDO){
        userDO.setId(1);
        userDO.setAccount("admin");
        userDO.setPassword(Md5Tool.encode("admin"));
        return userDO;
    }
}