package com.sszh.base.mapper;

import com.sszh.base.mapper.domain.Demo;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

/**
 * @author XuGuang
 * @Title: BaseMapper测试类
 * @Package  com.sszh.base.mapper
 * @Description: BaseMapper测试类
 * @date 2018/3/57:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j
public class BaseMapperTest {
    @Autowired
    private BaseMapper baseMapper;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testBase() throws Exception {
        log.info("testbase函数测试");
        Demo demo = new Demo();
        demo.setDName("张三");
        demo.setDGmtCreate(new Timestamp(System.currentTimeMillis()));
        baseMapper.insertSelective(demo);
        log.info("testbase函数完毕");
    }
}
