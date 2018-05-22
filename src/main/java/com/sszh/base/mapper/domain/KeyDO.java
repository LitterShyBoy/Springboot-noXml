package com.sszh.base.mapper.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author WangJianGuo
 * @Title: KeyDO
 * @Package com.sszh.base.mapper.domain
 * @Description: 秘钥实体类
 * @date 2018/3/15/015 14:17
 */
@Data
@Table(name = "sszh_base_key")
public class KeyDO {
    /**
     * ID
     */
    @Id
    @Column(name = "k_id")
    private Integer id;

    /**
     * APPID
     */
    @Column(name = "k_appid")
    private Integer appId;

    /**
     * KEY
     */
    @Column(name = "k_key")
    private String key;

    /**
     * CREATETIME
     */
    @Column(name = "k_gmt_create")
    private Date createtime;

    /**
     * MODIFIEDTIME
     */
    @Column(name = "k_gmt_modified")
    private Date modifiedtime;

    /**
     * 备用字段1
     */
    @Column(name = "k_m1")
    private String dM1;

    /**
     * 备用字段2
     */
    @Column(name = "k_m2")
    private String dM2;
}