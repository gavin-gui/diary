package com.gui.utils;

import com.gui.constant.Common;
import org.thymeleaf.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5摘要算法
 * Created by gavin on 2017/6/15.
 */
public class Md5Utils {

    /**
     * 获取字符串摘要
     * @param src 原字符串
     * @return
     */
    public static String md5(String src) {
        if(StringUtils.isEmpty(src)) {
            return null;
        }

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(withSalt(src).getBytes());
            return toHexStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 加盐
     * @param src
     * @return
     */
    private static String withSalt(String src) {
        return src + "{" + Common.SALT + "}";
    }

    /**
     * 字符数组转换成16进制字符串
     * @param digest
     * @return
     */
    private static String toHexStr(byte[] digest) {
        StringBuilder hexStr = new StringBuilder();
        for (byte b : digest) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) {
                hexStr.append("0");
            }
            hexStr.append(hex);
        }

        return hexStr.toString();
    }


}
