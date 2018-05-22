package com.sszh.base.mapper.domain;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author XuGuang
 * @Title: Demo
 * @Package com.sszh.base.mapper.domain
 * @Description: Demo实体类
 * @date 2018/3/57:05
 */
@Data
@Table(name = "sszh_base_demo")
public class Demo {
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * demo name
     */
    @Column(name = "d_name")
    private String dName;

    /**
     * create time
     */
    @Column(name = "d_gmt_create")
    private Timestamp dGmtCreate;

    /**
     * update time
     */
    @Column(name = "d_gmt_modified")
    private Timestamp dGmtModified;

    /**
     * 备用字段1
     */
    @Column(name = "d_m1")
    private String dM1;

    /**
     * 备用字段2
     */
    @Column(name = "d_m2")
    private String dM2;

}
