package com.sszh.base.controller;

import com.google.gson.Gson;
import com.google.common.reflect.TypeToken;
import com.sszh.base.configurer.token.TransmissionRequired;
import com.sszh.base.controller.inf.BaseControllerInf;
import com.sszh.base.controller.model.BaseModel;
import com.sszh.base.controller.model.DemoModel;
import com.sszh.base.controller.model.RequestDTO;
import com.sszh.base.controller.model.ResponseDTO;
import com.sszh.base.service.BaseService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author XuGuang
 * @Title: BaseController
 * @Package com.sszh.base.controller
 * @Description: 控制器
 * @date 2018/3/53:21
 */
@Log4j
@RestController
@RequestMapping("/sszh/base")
public class BaseController implements BaseControllerInf{
    @Autowired
    BaseService baseService;

    @Override
    @TransmissionRequired
    @RequestMapping( value = "/demobase",method = RequestMethod.POST )
    public String demoBase(@RequestParam("timestamp")String timestamp, @RequestAttribute("data")String data) {
        log.info("demoBase接口被请求，请求参数为:"+timestamp+","+data);
        Gson gson = new Gson();

        RequestDTO<DemoModel> requestDTO = gson.fromJson(data, new TypeToken<RequestDTO<DemoModel>> (){}.getType());
        log.info(requestDTO.toString());
        ResponseDTO responseDTO = new ResponseDTO();

        if (baseService.insertDemo(requestDTO)){
            responseDTO.setCode(1);
            responseDTO.setMessage("success");
        }else{
            responseDTO.setCode(0);
            responseDTO.setMessage("fail");
        }
        return gson.toJson(responseDTO);
    }
}
