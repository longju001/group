package com.jinxinkeji.comm.group.service.impl;

import com.alibaba.fastjson.JSON;
import com.jinxinkeji.comm.group.config.UserThreadLocal;
import com.jinxinkeji.comm.group.mapper.WeChatUserMapper;
import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.entity.WechatUser;
import com.jinxinkeji.comm.group.service.IWeChatUserService;
import com.jinxinkeji.comm.group.util.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author changyl
 * @create 2021-09-02 15:55
 */
@Service
public class WeChatUserServiceImpl implements IWeChatUserService {

    @Autowired
    private WeChatUserMapper weChatUserMapper;

    @Value("${token.salt}")
    private String salt;

    @Override
    @Transactional
    public Result<String> addUser(WechatUser wechatUser) throws Exception {
        if(weChatUserMapper.getCountByOpenId(wechatUser.getOpenId()) > 0){
            weChatUserMapper.updateUser(wechatUser);
        } else {
            weChatUserMapper.addUser(wechatUser);
        }

        return Result.success("新增完成", AESUtil.Encrypt(JSON.toJSONString(wechatUser), salt));
    }

    @Override
    public Result<String> addTuan(String phone, String name) {
        WechatUser wechatUser = UserThreadLocal.getUser();
        weChatUserMapper.addTuan(wechatUser.getOpenId(), phone, name);
        return Result.success("操作成功", null);
    }

    @Override
    public Result<String> memoryUser(WechatUser wechatUser) throws Exception {
        return Result.success("登录完成", AESUtil.Encrypt(JSON.toJSONString(wechatUser), salt));
    }
}
