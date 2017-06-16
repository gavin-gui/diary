package com.gui.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * Created by gavin on 2017/6/15.
 */
public class DateKit {

    //常用日期解析模式
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YYYYMMDD = "yyyy-MM-dd";
    public static final String PATTERN_HHMMSS = "HH:mm:ss";
    public static final String PATTERN_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式化为字符串
     * @param date 日期
     * @return
     */
    public static String format(Date date) {
        return format(date,DEFAULT_PATTERN);
    }

    /**
     * 日期转换为字符串
     * @param date 日期
     * @param pattern 模式
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 字符串解析为日期
     * @param dateStr 日期字符串
     * @return
     * @throws ParseException 解析异常
     * @throws IllegalArgumentException 参数异常
     */
    public static Date parse(String dateStr) throws ParseException,IllegalArgumentException {
        if(StringUtils.isEmpty(dateStr)) {
            throw new IllegalArgumentException("要解析的字符串不能为空");
        }
        return parse(dateStr,null);
    }

    /**
     * 字符串解析为日期
     * @param dateStr 日期字符串
     * @param pattern 模式
     * @return
     * @throws ParseException 解析异常
     * @throws IllegalArgumentException 参数异常
     */
    public static Date parse(String dateStr, String pattern) throws ParseException,IllegalArgumentException {
        if(StringUtils.isEmpty(dateStr)) {
            throw new IllegalArgumentException("待解析的字符串不能为空");
        }
        if(StringUtils.isEmpty(pattern)) {
            pattern = DEFAULT_PATTERN;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateStr);
    }


}
