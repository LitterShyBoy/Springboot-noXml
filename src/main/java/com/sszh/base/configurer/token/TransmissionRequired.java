package com.sszh.base.configurer.token;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author WangJianGuo
 * @Title: TransmissionRequired
 * @Package com.sszh.pzycxw.configurer.token
 * @Description: 在需要登录验证的Controller的方法上使用此注解
 * @date 2018/3/9/00911:54
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TransmissionRequired {
}