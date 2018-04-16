package com.mmall.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author Donqiuxote
 * @data 2018/4/9 12:51
 */
public class PropertiesUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties props;

    //加载顺序  静态代码块->普通代码块->构造器 构造器每次对象初始化时都会执行，静态代码块只在类被加载时执行一次 一般用于初始化静态变量
    static {
        String fileName = "mmall.properties";
        props = new Properties();

        try {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            logger.error("配置文件读取异常",e);
        }
    }

    public static String getProperty(String key){
        //key.trim()去除前后空格
        String value = props.getProperty(key.trim());
        if (value == null) {
            return null;
        }
        return value.trim();
    }

     public static String getProperty(String key,String defaultValue){
            //key.trim()去除前后空格
            String value = props.getProperty(key.trim());
            if (value == null) {
                value=defaultValue;
            }
            return value.trim();
        }


}
