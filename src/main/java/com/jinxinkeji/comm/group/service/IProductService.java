package com.jinxinkeji.comm.group.service;

import com.jinxinkeji.comm.group.model.entity.Category;
import com.jinxinkeji.comm.group.model.entity.Result;

import java.util.List;

/**
 * @author changyl
 * @create 2021-10-03 9:22
 */
public interface IProductService {
    Result<String> goodsList(long pageNum, String categoryCode);

    Result<List<Category>> categories();
}
