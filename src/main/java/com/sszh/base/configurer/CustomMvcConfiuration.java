package com.sszh.base.configurer;

import com.sszh.base.configurer.token.TokenConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author WangJianGuo
 * @Title:  CustomMvcConfiuration
 * @Package com.sszh.base.Configurer
 * @Description: 自定义拦截器
 * @date 2018/3/52:03
 */
@Configuration
public class CustomMvcConfiuration extends WebMvcConfigurationSupport {
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有 @TransmissionRequired 注解 决定是否需要登录
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    public TokenConfig authenticationInterceptor() {
        return new TokenConfig();
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //linux 路径
        registry.addResourceHandler("/image/**").addResourceLocations("file:./image/","classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("file:./static/","classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
