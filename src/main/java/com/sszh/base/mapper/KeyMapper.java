package com.sszh.base.mapper;

import com.sszh.base.mapper.domain.KeyDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author WangJianGuo
 * @Title: KeyMapper
 * @Package com.sszh.base.mapper
 * @Description: KeyMapper
 * @date 2018/3/30/030 10:16
 */
public interface KeyMapper extends Mapper<KeyDO> {
    /**
     * 通过appId查询key
     * @param appId
     * @return String
     */
    @Select("SELECT * FROM sszh_base_key WHERE k_appid = #{appId}")
    @Results({
            @Result(property = "key", column = "k_key"),
    })
    KeyDO getKeyByAppId(@Param("appId") int appId);

    /**
     * 得到AppId
     * @return
     */
    @Select("SELECT k_appid FROM sszh_base_key")
    @Results({
            @Result(property = "appId", column = "k_appid"),
    })
    Integer getAppId();
}