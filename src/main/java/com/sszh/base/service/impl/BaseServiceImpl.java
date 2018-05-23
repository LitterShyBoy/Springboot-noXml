package com.sszh.base.service.impl;

import com.sszh.base.controller.model.DemoModel;
import com.sszh.base.controller.model.RequestDTO;
import com.sszh.base.mapper.BaseMapper;
import com.sszh.base.mapper.domain.Demo;
import com.sszh.base.service.BaseService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author WangJianGuo
 * @Title: BaseServiceImpl
 * @Package com.sszh.base.service.impl
 * @Description: 实现BaseService 服务接口
 * @date 2018/3/517:22
 */
@Log4j
@Service
public class BaseServiceImpl implements BaseService{

	@Autowired
	private BaseMapper baseMapper;

	@Override
	public boolean insertDemo(RequestDTO<DemoModel> demoModel) {
        log.info("insertDemo服务层开启工作");
        Demo demo = new Demo();
        demo.setDName(demoModel.getPosts().getName());
        log.info(demo.toString());
		baseMapper.insertSelective(demo);
		return true;
	}
}
