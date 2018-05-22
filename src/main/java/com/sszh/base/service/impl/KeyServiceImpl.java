package com.sszh.base.service.impl;

import com.sszh.base.mapper.KeyMapper;
import com.sszh.base.mapper.domain.KeyDO;
import com.sszh.base.service.KeyService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WangJianGuo
 * @Title: KeyServiceImpl
 * @Package com.sszh.base.service.impl
 * @Description: Key服务实现类
 * @date 2018/3/30/030 10:19
 */
@Log4j
@Service
public class KeyServiceImpl implements KeyService{

    @Autowired
    KeyMapper keyMapper;

    @Override
    public KeyDO findKeyByAppId(int appId) {
        log.info("findKeyByAppId服务层开启工作");
        KeyDO key;
        key = keyMapper.getKeyByAppId(appId);
        log.info(keyMapper.getKeyByAppId(appId).toString());
        return key;
    }
}