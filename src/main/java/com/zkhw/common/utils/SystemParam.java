package com.zkhw.common.utils;

/**
 * 
 * @description 
 * @author zhangguanglong zhanggl@zksiot
 * @date 2018年4月1日 上午9:29:20
 * @version 1.0
 */
public class SystemParam {

    private static ThreadLocal<String> userIdThreadLocal = new ThreadLocal<>();

    public static void setUserId(String userId) {
        userIdThreadLocal.set(userId);
    }

    public static void removeUserId(){
        userIdThreadLocal.remove();
    }

    public static String getUserId(){
        return userIdThreadLocal.get();
    }

}
