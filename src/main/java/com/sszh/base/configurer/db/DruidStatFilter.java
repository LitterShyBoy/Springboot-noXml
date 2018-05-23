package com.sszh.base.configurer.db;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author WangJianGuo
 * @Title: DruidStatFilter
 * @Package  com.sszh.base.configurer.db
 * @Description: 配置监控拦截器
 * @date 2018/3/53:12
 */
@SuppressWarnings("serial")
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
        }
)
public class DruidStatFilter extends WebStatFilter {
}
