package com.sszh.base.configurer.aop;

import com.sszh.base.mapper.domain.KeyDO;
import com.sszh.base.service.KeyService;
import com.sszh.base.utils.AesTool;
import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author XuGuang
 * @Title: LogRecordAspect
 * @Package com.sszh.pzycxw.configurer.aop
 * @Description: 定义AOP 拦截所有controller层的接口
 * @date 2018/3/161:54
 */

@Log4j
@Aspect
@Configuration
public class LogRecordAspect {

    @Autowired
    KeyService keyService;
    /**
     * 切点
     */
    @Pointcut("execution(* com.sszh.base.controller.*Controller.*(..))")
    public void excudeService() {
    }

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        log.info("请求开始, 各个参数url:"+ url+",method: "+ method+",uri: "+uri+",params:"+queryString);

        String appid = request.getHeader("appid");

        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        KeyDO keydo = keyService.findKeyByAppId(Integer.parseInt(appid));
        String  aesResult = AesTool.encrypt(result.toString(), keydo.getKey());
        log.info("aop加密后："+aesResult);
        return aesResult;
    }
}
