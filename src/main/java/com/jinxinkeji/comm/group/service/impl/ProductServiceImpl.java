package com.jinxinkeji.comm.group.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinxinkeji.comm.group.config.UserThreadLocal;
import com.jinxinkeji.comm.group.mapper.ProductMapper;
import com.jinxinkeji.comm.group.model.entity.*;
import com.jinxinkeji.comm.group.model.vo.AddressVo;
import com.jinxinkeji.comm.group.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author changyl
 * @create 2021-10-03 9:22
 */
@Service
public class ProductServiceImpl implements IProductService {

    private static final long goodListPageSize = 10;
    private static final long commentPageSize = 10;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Result<IPage<MallGoods>> goodsList(long pageNum, long categoryId, String sortType, String keywords) {
        Page<MallGoods> p = new Page<>(pageNum, goodListPageSize);
        IPage<MallGoods> iPage = productMapper.selectGoodsPageVo(p, categoryId, sortType, keywords);
        return Result.success("成功", iPage);
    }

    @Override
    public Result<List<Category>> categories() {
        List<Category> list = productMapper.getCategoryList();
        return Result.success("查询类目成功", list);
    }

    @Override
    public Result<MallGoodsInfo> goodsInfo(long goodsId) {
        MallGoodsInfo info = productMapper.getGoodsInfo(goodsId);
        List<ProductForOrder> productList = productMapper.getProductList(goodsId);
        info.setProductList(productList);
        return Result.success("成功", info);
    }

    @Override
    public Result<List<MallGoodsComment>> goodsCommentListFirst(long goodsId) {
        List<MallGoodsComment> list = productMapper.goodsCommentListFirst(goodsId);
        return Result.success("成功", list);
    }


    @Override
    public Result<IPage<MallGoodsComment>> goodsCommentList(long goodsId, long pageNum) {
        Page<MallGoodsComment> p = new Page<>(pageNum, commentPageSize);
        IPage<MallGoodsComment> iPage = productMapper.goodsCommentListPageVo(p, goodsId);
        return Result.success("成功", iPage);
    }

    @Override
    public Result<String> addAddress(AddressVo vo) {
        productMapper.addAddress(vo);
        return Result.success("成功", null);
    }

    @Override
    public Result<String> removeAddress(long addressId) {
        productMapper.removeAddress(addressId);
        return Result.success("成功", null);
    }

    @Override
    public Result<String> setDefault(long addressId) {
        WechatUser user = UserThreadLocal.getUser();
        productMapper.setDefault(addressId);
        productMapper.setOtherNotDefault(addressId, user.getOpenId());
        return Result.success("成功", null);
    }

    @Override
    public Result<String> setNotDefault(long addressId) {
        productMapper.setNotDefault(addressId);
        return Result.success("成功", null);
    }

    @Override
    public Result<List<MallAddress>> addressList(String openId) {
        return Result.success("成功", productMapper.addressList(openId));
    }
}
