package com.sszh.base.service;

import com.sszh.base.controller.model.DemoModel;
import com.sszh.base.controller.model.RequestDTO;

/**
 * @author XuGuang
 * @Title: BaseService
 * @Package
 * @Description:
 * @date 2018/3/53:23
 */
public interface BaseService {
	/**
	 * 插入一条实体类Demo
	 *
	 * @param demoModel
 	 * @return 返回bool
	 */
	boolean insertDemo(RequestDTO<DemoModel> demoModel);
}
