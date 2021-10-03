package com.jinxinkeji.comm.group.mapper;

import com.jinxinkeji.comm.group.model.vo.ShopApplyVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author changyl
 * @create 2021-10-02 12:59
 */
@Mapper
public interface ShopMapper {
    void applys(ShopApplyVo shopApplyVo);
}
