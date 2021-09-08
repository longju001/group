package com.jinxinkeji.comm.group.mapper;

import com.jinxinkeji.comm.group.model.entity.WechatUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author changyl
 * @create 2021-09-02 15:57
 */
@Mapper
@Repository
public interface WeChatUserMapper {


    int addUser(WechatUser wechatUser);

    int getCountByOpenId(String openId);

    void updateUser(WechatUser wechatUser);
}
