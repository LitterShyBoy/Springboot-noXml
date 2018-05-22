package com.sszh.base.configurer.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.sszh.base.mapper.domain.UserDO;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author WangJianGuo
 * @Title: UserTokenManager
 * @Package com.sszh.pzycxw.utils
 * @Description: Token管理器
 * @date 2018/3/8/00821:21
 */

public class UserTokenManager {

    private static final byte[] SECRET = "hz445165165&".getBytes();
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
    private static final long  TTLMILLIS= 86400000;

    public static String getTokenToUser(UserDO user) {
        String token = "";
        long nowMillis = System. currentTimeMillis();
        JWTCreator.Builder jwt = JWT.create();
        jwt.withAudience(user.getId()+"");
        jwt.withIssuedAt(new Date(nowMillis));
        jwt.withExpiresAt(new Date(nowMillis+TTLMILLIS));
        try {
            token = jwt.sign( Algorithm.HMAC256(user.getPassword()));
        } catch (UnsupportedEncodingException e) {
        }
        return token;
    }
}