package com.jinxinkeji.comm.group.service.impl;

import com.jinxinkeji.comm.group.mapper.WeChatUserMapper;
import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.entity.WechatUser;
import com.jinxinkeji.comm.group.service.IWeChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    @Transactional
    public Result<String> addUser(WechatUser wechatUser) {
        if(weChatUserMapper.getCountByOpenId(wechatUser.getOpenId()) > 0){
            weChatUserMapper.updateUser(wechatUser);
        } else {
            weChatUserMapper.addUser(wechatUser);
        }
        return Result.success("新增完成", null);
    }
}
