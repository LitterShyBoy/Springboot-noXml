package com.sszh.base.service;

import com.sszh.base.controller.model.DemoModel;
import com.sszh.base.controller.model.RequestDTO;
import com.sszh.base.mapper.domain.Demo;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

/**
 * @author XuGuang
 * @Title: BaseServiceTest
 * @Package com.sszh.base.service
 * @Description: BaseService 服务测试类
 * @date 2018/3/517:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j
public class BaseServiceTest {
	@Autowired
	private BaseService baseService;
	@Test
	public void testServiceBase() throws Exception {
		log.info("testServiceBase服务测试");
		DemoModel demo = new DemoModel();
		demo.setName("服务");
		RequestDTO<DemoModel> requestDTO = new RequestDTO<>(demo);
		baseService.insertDemo(requestDTO);
		log.info("testServiceBase服务测试完毕");
	}
}
