package com.jinxinkeji.comm.group.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jinxinkeji.comm.group.model.entity.*;
import com.jinxinkeji.comm.group.model.vo.AddressVo;

import java.util.List;

/**
 * @author changyl
 * @create 2021-10-03 9:22
 */
public interface IProductService {
    Result<IPage<MallGoods>> goodsList(long pageNum, long categoryId, String sortType, String keywords);

    Result<List<Category>> categories();

    Result<MallGoodsInfo> goodsInfo(long goodsId);

    Result<List<MallGoodsComment>> goodsCommentListFirst(long goodsId);

    Result<IPage<MallGoodsComment>> goodsCommentList(long goodsId, long pageNum);

    Result<String> addAddress(AddressVo vo);

    Result<String> removeAddress(long addressId);

    Result<String> setDefault(long addressId);

    Result<String> setNotDefault(long addressId);
}
