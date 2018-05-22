package com.sszh.base.utils;

import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author WangJianGuo
 * @Title: SignatureUtil
 * @Package com.sszh.yygxt.utils
 * @Description: Sha1加密
 * @date TWO018/3/9/00915:45
 */
public class SignatureUtil {

    private  String encryptionAlgorithm = "SHA-1";

    /**
     * 使用指定算法生成消息摘要，默认是md5
     */
    public String digest(String strSrc, String encName) {
        MessageDigest md;
        String strDes;
        byte[] bt = strSrc.getBytes();
        try {
            if (encName == null || "".equals(encName)) {
                encName = "MD5";
            }
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = Md5Tool.bytesToHexString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }
    /**
     * 根据appid、token、lol以及时间戳来生成签名
     *
     * @param appid
     * @param token
     * @param lol
     * @param millis
     * @return
     */
    public String generateSignature(String appid, String token, String lol,
                                    long millis) {
        String timestamp = String.valueOf(millis);
        String signature = null;
        if (StringUtils.isNotBlank(token) && StringUtils.isNotBlank(timestamp)
                && StringUtils.isNotBlank(appid)) {
            List<String> srcList = new ArrayList<String>();
            srcList.add(timestamp);
            srcList.add(appid);
            srcList.add(token);
            srcList.add(lol);
            // 按照字典序逆序拼接参数
            Collections.sort(srcList);
            Collections.reverse(srcList);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < srcList.size(); i++) {
                sb.append(srcList.get(i));
            }
            System.out.println(sb.toString());
            signature = digest(sb.toString(), encryptionAlgorithm);
            srcList.clear();
            srcList = null;
        }
        return signature;
    }
}