package com.sszh.base.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author XuGuang
 * @Title: ResponseDTO
 * @Package com.sszh.base.controller.model
 * @Description: 返回信息通用类
 * @date 2018/3/83:04
 */
@ToString
public class ResponseDTO<T> {
    /**
     * 返回code 标识
     */
    @Setter @Getter private Integer code;
    /**
     * 返回message 信息
     */
    @Setter @Getter private String message;
    /**
     * 内容
     */
    @Setter @Getter private T posts;

    public ResponseDTO(T posts){
        this.posts=posts;
    }

    public ResponseDTO(){};
}
