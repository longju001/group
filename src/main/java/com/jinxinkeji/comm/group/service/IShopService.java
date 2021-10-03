package com.jinxinkeji.comm.group.service;

import com.jinxinkeji.comm.group.model.entity.Result;
import com.jinxinkeji.comm.group.model.vo.ShopApplyVo;

/**
 * @author changyl
 * @create 2021-10-02 12:53
 */
public interface IShopService {
    Result<String> shopApply(ShopApplyVo shopApplyVo);
}
