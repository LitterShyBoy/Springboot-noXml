package com.sszh.base.controller.inf;

/**
 * @author XuGuang
 * @Title: BaseControllerInf
 * @Package com.sszh.base.controller.inf
 * @Description: base控制层服务接口
 * @date 2018/3/522:40
 */
public interface BaseControllerInf {
    /**
     *
     * @api {PUT} /base/demBase BaseDemo接口
     * @apiGroup 请求返回统一规范
     * @apiName  接口示范
     * @apiDescription  接口示范
     * @apiVersion 1.0.0
     * @apiParam {String} timestamp 时间戳
     * @apiParam {json} data
     * @apiParamExample {json} Request-Example:
     * {"timestamp":"....","appid":"000001","posts":{"name":"李四","code":0}}
     * @apiSuccess (200) {String} code 1 成功 0 失败
     * @apiSuccess (200) {String} msg 返回信息
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {"code":1,"message":"测试成功","posts":{"name":"李四","code":0},{"name":"李四","code":0}}
     */
    /**
     * demo接口插入一条数据
     * @param timestamp
     * @param data
     * @return json结果
     */
    public String demoBase(String timestamp,String data);
}
