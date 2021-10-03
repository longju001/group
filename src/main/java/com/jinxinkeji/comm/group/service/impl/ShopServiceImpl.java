package com.jinxinkeji.comm.group.service.impl;

import com.jinxinkeji.comm.group.mapper.ShopMapper;
import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.vo.ShopApplyVo;
import com.jinxinkeji.comm.group.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author changyl
 * @create 2021-10-02 12:53
 */
@Service
public class ShopServiceImpl implements IShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Result<String> shopApply(ShopApplyVo shopApplyVo) {
        shopMapper.applys(shopApplyVo);
        return Result.success("申请成功", null);
    }
}
