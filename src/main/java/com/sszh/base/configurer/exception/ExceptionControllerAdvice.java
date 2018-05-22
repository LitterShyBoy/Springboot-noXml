package com.sszh.base.configurer.exception;

import com.google.gson.Gson;
import com.sszh.base.mapper.KeyMapper;
import com.sszh.base.mapper.domain.KeyDO;
import com.sszh.base.service.KeyService;
import com.sszh.base.utils.AesTool;
import com.sszh.base.utils.Constant;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * @author WangJianGuo
 * @Title:  ExceptionControllerAdvice
 * @Package com.sszh.pzycxw.configurer.exception
 * @Description: 全局异常处理类
 * @date 2018/3/29/029 9:06
 */
@Log4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    KeyService keyService;

    @Autowired
    KeyMapper keyMapper;

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String myErrorHandler(Exception ex) {
        log.info("异常信息如下： ");
        ex.printStackTrace();
        Map map = new HashMap(2);
        map.put("code", 100);
        map.put("msg", Constant.EXCEPTION);
        Gson gson = new Gson();
        String info = gson.toJson(map);
        log.info(info);
        KeyDO keydo = keyService.findKeyByAppId(keyMapper.getAppId());
        String aesResult = AesTool.encrypt(info.toString(), keydo.getKey());
        return aesResult;
    }
}