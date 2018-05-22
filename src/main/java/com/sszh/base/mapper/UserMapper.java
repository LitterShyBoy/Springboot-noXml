package com.sszh.base.mapper;

import com.sszh.base.mapper.domain.UserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author WangJianGuo
 * @Title: UserMapper
 * @Package com.sszh.base.mapper
 * @Description: 用户Mapper
 * @date 2018/3/30/030 10:43
 */
public interface UserMapper extends Mapper<UserDO>{
    /**
     * 通过UserId查询
     * @param id
     * @return UserDO
     */
    @Select("SELECT * FROM sszh_base_user WHERE u_id = #{id}")
    @Results({
            @Result(property = "id", column = "u_id"),
            @Result(property = "name", column = "u_name"),
            @Result(property = "account", column = "u_account"),
            @Result(property = "password", column = "u_password"),
            @Result(property = "permission", column = "u_permission"),
    })
    UserDO getUserById(@Param("id") int id);
}