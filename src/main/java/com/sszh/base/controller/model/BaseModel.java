package com.sszh.base.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author XuGuang
 * @Title: BaseModel
 * @Package com.sszh.base.controller.model
 * @Description: json返回必带字段
 * @date 2018/3/60:45
 */
@ToString
public class BaseModel {
    @Setter @Getter private int code;
    @Setter @Getter private String message;
}
