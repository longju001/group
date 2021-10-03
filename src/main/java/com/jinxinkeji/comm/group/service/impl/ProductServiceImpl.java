package com.jinxinkeji.comm.group.service.impl;

import com.jinxinkeji.comm.group.mapper.ProductMapper;
import com.jinxinkeji.comm.group.model.entity.Category;
import com.jinxinkeji.comm.group.model.entity.Result;
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

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Result<String> goodsList(long pageNum, String categoryCode) {
        return null;
    }

    @Override
    public Result<List<Category>> categories() {
        List<Category> list = productMapper.getCategoryList();
        return Result.success("查询类目成功", list);
    }
}
