package com.jinxinkeji.comm.group.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinxinkeji.comm.group.model.entity.*;
import com.jinxinkeji.comm.group.model.vo.AddressVo;
import com.jinxinkeji.comm.group.model.vo.MessageListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author changyl
 * @create 2021-10-03 9:50
 */
@Mapper
public interface ProductMapper {
    List<Category> getCategoryList();

    IPage<MallGoods> selectGoodsPageVo(Page<MallGoods> p, long categoryId, String sortType, String keywords);

    MallGoodsInfo getGoodsInfo(long goodsId);

    List<ProductForOrder> getProductList(long goodsId);

    List<MallGoodsComment> goodsCommentListFirst(long goodsId);

    IPage<MallGoodsComment> goodsCommentListPageVo(Page<MallGoodsComment> p, long goodsId);

    void addAddress(AddressVo vo);

    void removeAddress(long addressId);

    void setDefault(long addressId);

    void setOtherNotDefault(long addressId, String openId);

    void setNotDefault(long addressId);
}
