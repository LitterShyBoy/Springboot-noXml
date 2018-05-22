package com.sszh.base.controller;

import com.google.gson.Gson;
import com.sszh.base.configurer.token.TokenConfig;
import com.sszh.base.configurer.token.UserTokenManager;
import com.sszh.base.controller.model.BaseModel;
import com.sszh.base.controller.model.DemoModel;
import com.sszh.base.controller.model.RequestDTO;
import com.sszh.base.mapper.domain.UserDO;
import com.sszh.base.utils.AesTool;
import com.sszh.base.utils.GetToken;
import com.sszh.base.utils.Md5Tool;
import com.sszh.base.utils.SignatureUtil;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author XuGuang
 * @Title: BaseControllerTest
 * @Package com.sszh.base.controller
 * @Description: BaseController测试类
 * @date 2018/3/61:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j
public class BaseControllerTest {
    private MockMvc mockMvc;

    @Autowired
    BaseController baseController;

    @Autowired
    TokenConfig tokenConfig;

    String token;

    @Before
    public void setMockMvc(){
        mockMvc = MockMvcBuilders.standaloneSetup(baseController).addInterceptors(tokenConfig).build();
        UserDO userDO =  new UserDO();
        userDO = GetToken.getTokens(userDO);
        token= UserTokenManager.getTokenToUser(userDO);
        log.info("befor:" + token);
    }
    @Test
    public void demoBase() throws Exception{
        log.info("测试demoBase");
        DemoModel demoModel = new DemoModel();
        demoModel.setName("李四");
        RequestDTO<DemoModel> requestModel = new RequestDTO<>(demoModel);
        requestModel.setAppid("123");
        requestModel.setTimestamp(System.currentTimeMillis()+"");
        String questJsom = new Gson().toJson(requestModel);
        log.info(questJsom);
        SignatureUtil signatureUtil = new SignatureUtil();
        String aesJson = AesTool.encrypt(questJsom,"sfq134sd234123df");
        String lol = signatureUtil.digest(aesJson,"MD5");
        long timestamp = System.currentTimeMillis();
        String sig = signatureUtil.generateSignature("123",token,lol,timestamp);

        ResultActions addResult = mockMvc.perform(MockMvcRequestBuilders.post("/sszh/base/demobase")
                .header("token", token)
                .header("appid", 123)
                .header("lol", lol)
                .header("timestamp", timestamp)
                .header("signature", sig)
                .param("timestamp", timestamp+"")
                .param("data",aesJson));
        log.info("状态码:"+addResult.andReturn().getResponse().getStatus());
        log.info("测试demoBase完毕，返回结果为:"+addResult.andReturn().getResponse().getContentAsString());
    }
}
