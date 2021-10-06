package com.jinxinkeji.comm.group.mapper;

import com.jinxinkeji.comm.group.model.entity.WechatUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<WechatUser> getUserByOpenId(String openId);

    void addTuan(String openId, String phone, String name);
}
