package com.sszh.base.service;

import com.sszh.base.mapper.domain.KeyDO;
import org.springframework.stereotype.Service;

/**
 * @author WangJianGuo
 * @Title: KeyService
 * @Package com.sszh.base.service
 * @Description: Key服务
 * @date 2018/3/30/030 10:15
 */
@Service
public interface KeyService {
    /**
     * 根据appId查找key
     * @param appId
     * @return String
     */
    KeyDO findKeyByAppId(int appId);
}