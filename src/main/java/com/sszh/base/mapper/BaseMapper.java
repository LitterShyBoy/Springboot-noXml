package com.sszh.base.mapper;

import com.sszh.base.mapper.domain.Demo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author WangJianGuo
 * @Title:BaseMapper
 * @Package com.sszh.base.mapper
 * @Description: Base服务器层
 * @date 2018/3/53:40
 */
@Service
public interface BaseMapper extends Mapper<Demo>{
}
