package com.jinxinkeji.comm.group.service;

import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.entity.WechatUser;

/**
 * @author changyl
 * @create 2021-09-02 15:47
 */
public interface IWeChatUserService {


    Result<String> addUser(WechatUser wechatUser) throws Exception;
}
