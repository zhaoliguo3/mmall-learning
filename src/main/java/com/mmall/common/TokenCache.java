package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 本地缓存，用于存放token
 * @author Donqiuxote
 * @data 2018/3/31 15:26
 */
public class TokenCache {

    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    public static final String TOKEN_prifix="token";

    //声明静态内存块  guava 本地缓存
    private static LoadingCache<String,String> localCache = CacheBuilder.newBuilder()
            //设置缓存的初始化容量
            .initialCapacity(1000)
            //缓存的最大容量  超过后使用LRU算法（最少使用算法） 来移除缓存项
            .maximumSize(10000)
            //有效期
            .expireAfterAccess(12, TimeUnit.HOURS)
            //build(CacheLoader  抽象类) 我们需要写一个实现类 或匿名实现
            .build(new CacheLoader<String, String>() {
                //默认的数据加载实现 当调用get取值时，如果key没有对应的值，则调用此方法进行加载
                @Override
                public String load(String s) throws Exception {
                    return "null";     //防止空指针
                }
            });

    public static void setKey(String key,String value){
        localCache.put(key,value);
    }

    public static String getKey(String key){
        String value = null;
        try {
            value = localCache.get(key);
            if ("null".equals(value)){
                return null;
            }
            return value;
        } catch (ExecutionException e) {
            logger.error("localCache get error",e);
        }
        return null;
    }
}
