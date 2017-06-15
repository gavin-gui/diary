package com.gui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/15.
 */
public class DateKit {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";


    public static String format(Date date) {
        return format(date,DEFAULT_PATTERN);
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

}
