package com.sszh.base.configurer.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sszh.base.mapper.KeyMapper;
import com.sszh.base.mapper.domain.KeyDO;
import com.sszh.base.mapper.domain.UserDO;
import com.sszh.base.service.KeyService;
import com.sszh.base.service.UserService;
import com.sszh.base.utils.AesTool;
import com.sszh.base.utils.SignatureUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/**
 * @author WangJianGuo
 * @Title: TokenConfig
 * @Package com.sszh.base.configurer.token
 * @Description: Token拦截器
 * @date 2018/3/9/00911:48
 */
@Log4j
public class TokenConfig implements HandlerInterceptor {

    private static String MD5 = "MD5";

    SignatureUtil signatureUtil = new SignatureUtil();

    @Autowired
    private UserService userService;

    @Autowired
    private KeyService keyService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断接口是否需要登录
        TransmissionRequired methodAnnotation = method.getAnnotation(TransmissionRequired.class);
        // 有 @TransmissionRequired 注解，需要认证
        if (methodAnnotation != null) {
            // 执行认证
            // 从 http 请求头中取出 token
            String token = request.getHeader("token");
            log.info("Token:  " + token);
            if (token == null) {
                response.setStatus(110);
                log.info("token无效或过期，请重新登录");
                return false;
            }
            int userId;
            try {
                // 获取 token 中的 user id

                userId = Integer.parseInt(JWT.decode(token).getAudience().get(0));
            } catch (JWTDecodeException e) {
                response.setStatus(110);
                log.info("token无效或过期，请重新登录");
                return false;
            }
            UserDO user = userService.findById(userId);
            if (user == null) {
                response.setStatus(110);
                log.info("token无效或过期，请重新登录");
                return false;
            }

            log.info("password: " + user.getPassword());
            // 验证 token
            try {
                JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    verifier.verify(token);
                } catch (JWTVerificationException e) {
                    response.setStatus(110);
                    log.info("token无效或过期，请重新登录");
                    return false;
                }
            } catch (UnsupportedEncodingException ignore) {
                response.setStatus(110);
                log.info("token无效或过期，请重新登录");
                return false;
            }

            //开始验证签名
            log.info("验证签名");
            String appid = request.getHeader("appid");
            String signature = request.getHeader("signature");
            long timestamp = Long.parseLong(request.getHeader("timestamp"));
            String lol = request.getHeader("lol");
            //加密后的json
            String data = request.getParameter("data");
            log.info(data);
            //字符逆序排列计算出signatures
            String signatures = signatureUtil.generateSignature(appid, token, lol, timestamp);
            log.info(signatures+","+signature);
            if(signature.equals(signatures)){
                log.info("签名认证通过");
                if(signatureUtil.digest(data,MD5).equals(lol)){
                    //解密data数据修改传过来的数据
                    log.info("摘要认证通过");
                    KeyDO keydo;
                    keydo = keyService.findKeyByAppId(Integer.parseInt(appid));
                    log.info("数据：" + AesTool.desEncrypt(data, keydo.getKey()));
                    request.setAttribute("data", AesTool.desEncrypt(data, keydo.getKey()).trim());
                    return true;
            }
                response.setStatus(112);
                log.info("摘要认证失败");
                return false;
            }
            response.setStatus(111);
            log.info("签名认证失败");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        //log.info(handler.getClass().getSimpleName());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}