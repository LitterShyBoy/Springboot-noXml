package com.sszh.base;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
* @Title:  BaseApplication
* @Package com.sszh.base
* @Description: Spring boot start class
* @author WangJianGuo
* @date 2018/3/416:17
*/
@SpringBootApplication
@ServletComponentScan
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.sszh.base.mapper")
public class BaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(BaseApplication.class, args);
	}

	//分页框架

	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("dialect", "mysql");
		pageHelper.setProperties(properties);
		return pageHelper;
	}
}
