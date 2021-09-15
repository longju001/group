package com.jinxinkeji.comm.group.config;

import com.jinxinkeji.comm.group.model.entity.WechatUser;
import org.springframework.core.NamedThreadLocal;

/**
 * @author changyl
 * @create 2021-09-15 15:34
 */
public class UserThreadLocal {
    private static ThreadLocal<WechatUser> userThread = new NamedThreadLocal<>("User_session");

    public static void setUser(WechatUser user){
        userThread.set(user);
    }

    public static WechatUser getUser(){
        return userThread.get();
    }

    //防止内存泄漏
    public static void remove(){
        userThread.remove();
    }
}
