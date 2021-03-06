define({ "api": [
  {
    "type": "PUT",
    "url": "/base/demBase",
    "title": "BaseDemo接口",
    "group": "________",
    "name": "____",
    "description": "<p>接口示范</p>",
    "version": "1.0.0",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "timestamp",
            "description": "<p>时间戳</p>"
          },
          {
            "group": "Parameter",
            "type": "json",
            "optional": false,
            "field": "data",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\"timestamp\":\"124124214532\",\"token\":\"assfsdafsfs@d2w12213sd\",\"lol\":\"sdsfsfsd\",\"appid\":\"000001\",\"posts\":{\"name\":\"李四\",\"code\":0}}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>1 成功 0 失败</p>"
          },
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>返回信息</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":1,\"message\":\"测试成功\",\"posts\":[{\"name\":\"李四\",\"code\":0},{\"name\":\"李四\",\"code\":0}]}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/sszh/base/controller/inf/BaseControllerInf.java",
    "groupTitle": "________"
  }
] });
