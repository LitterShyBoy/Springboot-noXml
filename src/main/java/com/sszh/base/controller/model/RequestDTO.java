package com.sszh.base.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author XuGuang
 * @Title: RequestDTO
 * @Package com.sszh.base.controller.model
 * @Description: 接受请求通用类
 * @date 2018/3/82:53
 */
@ToString
public class RequestDTO<T> {
    /**
     * 时间戳
     */
    @Setter @Getter private String  timestamp;
   /**
     * 对应id
     */
    @Setter @Getter private String  appid;
    /**
     * 页码
     */
    @Setter @Getter private Integer pageNow;
    /**
     * 内容
     */
    @Setter @Getter private T posts;

    public RequestDTO(T posts){
        this.posts = posts;
    }

    public RequestDTO(){}
}
