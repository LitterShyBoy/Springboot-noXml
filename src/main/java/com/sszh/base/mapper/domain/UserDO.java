package com.sszh.base.mapper.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @author WangJianGuo
 * @Title: UserDO
 * @Package com.sszh.base.mapper.domain
 * @Description: 用户实体类
 * @date 2018/3/30/030 10:28
 */
@Data
@Table(name = "sszh_base_user")
public class UserDO {
    /**
     * ID
     */
    @Id
    @Column(name = "u_id")
    private Integer id;

    /**
     * NAME
     */
    @Column(name = "u_name")
    private String name;

    /**
     * ACCOUNT
     */
    @Column(name = "u_account")
    private String account;

    /**
     * PASSWORD
     */
    @Column(name = "u_password")
    private String password;

    /**
     * PERMISSION
     */
    @Column(name = "u_permission")
    private Integer permission;

    /**
     * GMT_CREATE
     */

    @Column(name = "u_gmt_create")
    private Date gmtCreate;

    /**
     * GMT_MODIFIED
     */
    @Column(name = "u_gmt_modified")
    private Date gmtModified;

    /**
     * 备用字段1
     */
    @Column(name = "u_m1")
    private String dM1;

    /**
     * 备用字段2
     */
    @Column(name = "u_m2")
    private String dM2;
}