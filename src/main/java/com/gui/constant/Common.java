package com.gui.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/16.
 */
@Component
@Configuration
@PropertySource(value = "classpath:config.properties")
@EnableAutoConfiguration
public class Common {

    @Value("${const.salt}")
    public static String SALT;

}
